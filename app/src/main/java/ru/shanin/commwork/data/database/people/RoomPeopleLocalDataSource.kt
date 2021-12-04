package ru.shanin.commwork.data.database.people

import kotlinx.coroutines.flow.Flow
import ru.shanin.commwork.domain.entity.People

interface RoomPeopleLocalDataSource {
    suspend fun getPeopleList(): Flow<List<People>>
    suspend fun addPeople(people: People)
    suspend fun getPeople(peopleId: Int): People
    suspend fun deleteAll()
    suspend fun deletePeople(peopleId: Int)
}