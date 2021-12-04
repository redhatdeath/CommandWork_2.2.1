package ru.shanin.commwork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.shanin.commwork.data.entity.RoomPeopleEntity

@Dao
interface RoomPeopleDao {
    @Query("SELECT * FROM people")
    fun getRoomPeopleEntityAll(): Flow<List<RoomPeopleEntity>>

    @Query("SELECT * FROM people WHERE people_id IN (:peopleIds)")
    fun getRoomPeopleEntityAllByIds(peopleIds: IntArray): List<RoomPeopleEntity>

    @Query("SELECT * FROM people WHERE people_id LIKE :peopleId LIMIT 1")
    fun getRoomPeopleEntityById(peopleId: Int): RoomPeopleEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomPeopleEntity(roomPeopleEntity: RoomPeopleEntity)
}