package ru.shanin.data.database.repository

import kotlinx.coroutines.flow.Flow
import ru.shanin.domain.entity.Work

interface RoomWorkLocalDataSourceRepository {
    suspend fun getCommandWorkList(): Flow<List<Work>>
    suspend fun getCommandWorkListById(listOfCommandWorkId: IntArray): Flow<List<Work>>
    suspend fun addCommandWork(work: Work)
    suspend fun getCommandWork(commandWorkId: Int): Work
}