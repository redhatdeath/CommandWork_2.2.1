package ru.shanin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.shanin.data.entity.RoomWorkEntity

@Dao
interface RoomCommandWorkDao {
    @Query("SELECT * FROM work")
    fun getRoomCommandWorkEntityAll(): Flow<List<RoomWorkEntity>>

    @Query("SELECT * FROM work WHERE command_work_id IN (:commandWorkIds)")
    fun getRoomCommandWorkEntityAllByIds(commandWorkIds: IntArray): Flow<List<RoomWorkEntity>>

    @Query("SELECT * FROM work WHERE command_work_id LIKE :commandWorkId LIMIT 1")
    fun getRoomCommandWorkEntityById(commandWorkId: Int): RoomWorkEntity

    @Insert
    fun insertRoomCommandWorkEntity(workEntity: RoomWorkEntity)

}