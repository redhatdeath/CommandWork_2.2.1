package ru.shanin.commwork.data.database

import androidx.room.Database
import androidx.room.TypeConverters
import ru.shanin.commwork.data.entity.RoomCommandWorkEntity

@Database(entities = [RoomCommandWorkEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomCommandWorkDatabase {
    abstract fun roomCommandWorkDao(): RoomCommandWorkDao
}