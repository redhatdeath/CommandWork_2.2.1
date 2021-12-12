package ru.shanin.data.repositoryimpl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.shanin.data.database.dao.RoomPeopleDao
import ru.shanin.data.database.repository.RoomPeopleLocalDataSourceDataRepository
import ru.shanin.data.mappers.PeopleEntityMapper
import ru.shanin.domain.entity.People

class RoomPeopleLocalDataSourceDataRepositoryImpl(
    private val roomPeopleDao: RoomPeopleDao,
    private val dispatcher: CoroutineDispatcher,
    private val peopleEntityMapper: PeopleEntityMapper
) : RoomPeopleLocalDataSourceDataRepository {
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