package ru.shanin.data.database.repository

import kotlinx.coroutines.flow.Flow
import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

interface RoomPeopleLocalDataSourceDataRepository: PeopleDataRepository {
    override suspend fun getPeopleList(): Flow<List<People>>
    suspend fun addPeople(people: People)
    suspend fun getPeople(peopleId: Int): People
    suspend fun deleteAll()
    suspend fun deletePeople(peopleId: Int)
}