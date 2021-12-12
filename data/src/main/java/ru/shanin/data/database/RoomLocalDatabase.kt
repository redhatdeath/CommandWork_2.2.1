package ru.shanin.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shanin.data.database.dao.RoomCommandWorkDao
import ru.shanin.data.database.dao.RoomPeopleDao
import ru.shanin.data.entity.RoomWorkEntity
import ru.shanin.data.entity.RoomPeopleEntity
import ru.shanin.data.mappers.Converters

@Database(
    entities = [
        RoomPeopleEntity::class,
        RoomWorkEntity::class
    ],
    version = RoomLocalDatabase.DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RoomLocalDatabase : RoomDatabase() {
    abstract fun roomCommandWorkDao(): RoomCommandWorkDao
    abstract fun roomPeopleDao(): RoomPeopleDao

    companion object {

        const val DATABASE_VERSION = 1

        @Volatile
        private var INSTANCE: RoomLocalDatabase? = null

        fun getDatabase(appContext: Context): RoomLocalDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext,
                    RoomLocalDatabase::class.java,
                    RoomLocalDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}