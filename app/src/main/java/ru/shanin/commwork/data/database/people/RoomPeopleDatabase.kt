package ru.shanin.commwork.data.database.people

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shanin.commwork.data.database.Converters
import ru.shanin.commwork.data.entity.RoomPeopleEntity

@Database(entities = [RoomPeopleEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomPeopleDatabase() : RoomDatabase() {
    abstract fun roomPeopleDao(): RoomPeopleDao


    companion object {
        @Volatile
        private var INSTANCE: RoomPeopleDatabase? = null

        fun getDatabase(appContext: Context): RoomPeopleDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext, RoomPeopleDatabase::class.java,
                    RoomPeopleDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}