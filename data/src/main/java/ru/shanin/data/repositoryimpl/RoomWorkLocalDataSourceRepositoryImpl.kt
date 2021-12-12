package ru.shanin.data.repositoryimpl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.shanin.data.database.dao.RoomCommandWorkDao
import ru.shanin.data.database.repository.RoomWorkLocalDataSourceRepository
import ru.shanin.data.mappers.CommandWorkEntityMapper
import ru.shanin.domain.entity.Work

class RoomWorkLocalDataSourceRepositoryImpl(
    private val roomCommandWorkDao: RoomCommandWorkDao,
    private val dispatcher: CoroutineDispatcher,
    private val commandWorkEntityMapper: CommandWorkEntityMapper
) : RoomWorkLocalDataSourceRepository {

    override suspend fun getCommandWorkList(
    ): Flow<List<Work>> {
        val savedCommandWorkEntityFlow =
            roomCommandWorkDao.getRoomCommandWorkEntityAll()
        return savedCommandWorkEntityFlow.map { list ->
            list.map { element ->
                commandWorkEntityMapper.toCommandWork(element)
            }
        }
    }

    override suspend fun getCommandWorkListById(
        listOfCommandWorkId: IntArray
    ): Flow<List<Work>> {
        val savedCommandWorkEntityFlow =
            roomCommandWorkDao.getRoomCommandWorkEntityAllByIds(listOfCommandWorkId)
        return savedCommandWorkEntityFlow.map { list ->
            list.map { element ->
                commandWorkEntityMapper.toCommandWork(element)
            }
        }
    }

    override suspend fun addCommandWork(
        work: Work
    ) = withContext(dispatcher) {
        roomCommandWorkDao.insertRoomCommandWorkEntity(
            commandWorkEntityMapper.toRoomCommandWorkEntity(work)
        )
    }

    override suspend fun getCommandWork(
        commandWorkId: Int
    ): Work {
        return commandWorkEntityMapper.toCommandWork(
            roomCommandWorkDao.getRoomCommandWorkEntityById(
                commandWorkId
            )
        )
    }
}