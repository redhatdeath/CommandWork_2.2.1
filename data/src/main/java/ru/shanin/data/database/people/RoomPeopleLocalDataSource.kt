package ru.shanin.commwork.data.database.people

import kotlinx.coroutines.flow.Flow
import ru.shanin.domain.domain.entity.People

interface RoomPeopleLocalDataSource {
    suspend fun getPeopleList(): Flow<List<ru.shanin.domain.domain.entity.People>>
    suspend fun addPeople(people: ru.shanin.domain.domain.entity.People)
    suspend fun getPeople(peopleId: Int): ru.shanin.domain.domain.entity.People
    suspend fun deleteAll()
    suspend fun deletePeople(peopleId: Int)
}