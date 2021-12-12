package ru.shanin.data.repositoryimpl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.shanin.data.database.commandwork.RoomCommandWorkDao
import ru.shanin.data.database.repository.RoomCommandWorkLocalDataSourceRepository
import ru.shanin.data.mappers.CommandWorkEntityMapper
import ru.shanin.domain.entity.CommandWork

class RoomCommandWorkLocalDataSourceRepositoryImpl(
    private val roomCommandWorkDao: RoomCommandWorkDao,
    private val dispatcher: CoroutineDispatcher,
    private val commandWorkEntityMapper: CommandWorkEntityMapper
) : RoomCommandWorkLocalDataSourceRepository {
    override suspend fun getCommandWorkList(): Flow<List<CommandWork>> {
        val savedCommandWorkEntityFlow = roomCommandWorkDao.getRoomCommandWorkEntityAll()
        return savedCommandWorkEntityFlow.map { list ->
            list.map { element ->
                commandWorkEntityMapper.toCommandWork(element)
            }
        }
    }

    override suspend fun addCommandWork(commandWork: CommandWork) = withContext(dispatcher) {
        roomCommandWorkDao.insertRoomCommandWorkEntity(
            commandWorkEntityMapper.toRoomCommandWorkEntity(commandWork)
        )
    }

    override suspend fun getCommandWork(commandWorkId: Int): CommandWork {
        return commandWorkEntityMapper.toCommandWork(
            roomCommandWorkDao.getRoomCommandWorkEntityById(
                commandWorkId
            )
        )
    }
}