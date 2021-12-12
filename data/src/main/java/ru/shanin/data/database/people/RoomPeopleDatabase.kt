package ru.shanin.data.database.people

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.shanin.data.database.people.RoomPeopleDatabase.Companion.DATABASE_VERSION
import ru.shanin.data.entity.RoomPeopleEntity

@Database(
    entities = [RoomPeopleEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class RoomPeopleDatabase() : RoomDatabase() {
    abstract fun roomPeopleDao(): RoomPeopleDao

    companion object {

        const val DATABASE_VERSION = 1

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