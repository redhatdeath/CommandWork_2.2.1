package ru.shanin.data.database.repository

import kotlinx.coroutines.flow.Flow
import ru.shanin.domain.entity.CommandWork

interface RoomCommandWorkLocalDataSourceRepository {
    suspend fun getCommandWorkList(): Flow<List<CommandWork>>
    suspend fun addCommandWork(commandWork: CommandWork)
    suspend fun getCommandWork(commandWorkId: Int): CommandWork
}