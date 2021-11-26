package ru.shanin.commwork.data.database

import androidx.room.Insert
import androidx.room.Query
import ru.shanin.commwork.data.entity.RoomCommandWorkEntity

interface RoomCommandWorkDao {
    @Query("SELECT * FROM work")
    fun getRoomCommandWorkEntityAll(): List<RoomCommandWorkEntity>

    @Query("SELECT * FROM work WHERE command_work_id IN (:commandWorkIds)")
    fun getRoomCommandWorkEntityAllByIds(commandWorkIds: IntArray): List<RoomCommandWorkEntity>

    @Query("SELECT * FROM work WHERE command_work_id LIKE :commandWorkId LIMIT 1")
    fun getRoomCommandWorkEntityById(commandWorkId: Int): RoomCommandWorkEntity

    @Insert
    fun insertRoomCommandWorkEntity(commandWorkEntity: RoomCommandWorkEntity)

}