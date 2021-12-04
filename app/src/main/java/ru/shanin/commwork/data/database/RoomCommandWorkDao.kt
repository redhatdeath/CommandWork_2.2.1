package ru.shanin.commwork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.shanin.commwork.data.entity.RoomCommandWorkEntity

@Dao
interface RoomCommandWorkDao {
    @Query("SELECT * FROM work")
    fun getRoomCommandWorkEntityAll(): Flow<List<RoomCommandWorkEntity>>

    @Query("SELECT * FROM work WHERE command_work_id IN (:commandWorkIds)")
    fun getRoomCommandWorkEntityAllByIds(commandWorkIds: IntArray): List<RoomCommandWorkEntity>

    @Query("SELECT * FROM work WHERE command_work_id LIKE :commandWorkId LIMIT 1")
    fun getRoomCommandWorkEntityById(commandWorkId: Int): RoomCommandWorkEntity

    @Insert
    fun insertRoomCommandWorkEntity(commandWorkEntity: RoomCommandWorkEntity)

}