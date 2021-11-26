package ru.shanin.commwork.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shanin.commwork.data.entity.RoomPeopleEntity

@Database(entities = [RoomPeopleEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomPeopleDatabase : RoomDatabase() {
    abstract fun roomPeopleDao(): RoomPeopleDao

}