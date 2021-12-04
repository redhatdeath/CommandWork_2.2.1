package ru.shanin.commwork.data.database.people

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.shanin.commwork.data.mappers.PeopleEntityMapper
import ru.shanin.commwork.domain.entity.People

class RoomPeopleLocalDataSourceImpl(
    private val roomPeopleDao: RoomPeopleDao,
    private val dispatcher: CoroutineDispatcher,
    private val peopleEntityMapper: PeopleEntityMapper
) : RoomPeopleLocalDataSource {
    override suspend fun getPeopleList(): Flow<List<People>> {
        val savedPeopleEntityFlow = roomPeopleDao.getRoomPeopleEntityAll()
        return savedPeopleEntityFlow.map { list ->
            list.map { element ->
                peopleEntityMapper.toPeople(element)
            }
        }
    }

    override suspend fun addPeople(people: People) = withContext(dispatcher) {
        roomPeopleDao.insertRoomPeopleEntity(
            peopleEntityMapper.toRoomPeopleEntity(people)
        )
    }

    override suspend fun getPeople(peopleId: Int): People {
        return peopleEntityMapper.toPeople(
            roomPeopleDao.getRoomPeopleEntityById(
                peopleId
            )
        )
    }

    override suspend fun deleteAll() {
        roomPeopleDao.deleteAllUsers()
    }

    override suspend fun deletePeople(peopleId: Int) {
        roomPeopleDao.delete(peopleId)
    }
}