package ru.shanin.commwork.data.database

import androidx.room.Insert
import androidx.room.Query
import ru.shanin.commwork.data.entity.RoomPeopleEntity

interface RoomPeopleDao {
    @Query("SELECT * FROM people")
    fun getRoomPeopleEntityAll(): List<RoomPeopleEntity>

    @Query("SELECT * FROM people WHERE people_id IN (:peopleIds)")
    fun getRoomPeopleEntityAllByIds(peopleIds: IntArray): List<RoomPeopleEntity>

    @Query("SELECT * FROM people WHERE people_id LIKE :peopleId LIMIT 1")
    fun getRoomPeopleEntityById(peopleId: Int): RoomPeopleEntity

    @Insert
    fun insertRoomPeopleEntity(roomPeopleEntity: RoomPeopleEntity)
}