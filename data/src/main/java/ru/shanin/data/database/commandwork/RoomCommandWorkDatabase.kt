package ru.shanin.data.database.commandwork

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.shanin.data.database.commandwork.RoomCommandWorkDatabase.Companion.DATABASE_VERSION
import ru.shanin.data.entity.RoomCommandWorkEntity

@Database(
    entities = [RoomCommandWorkEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class RoomCommandWorkDatabase : RoomDatabase() {
    abstract fun roomCommandWorkDao(): RoomCommandWorkDao

    companion object {

        const val DATABASE_VERSION = 1

        @Volatile
        private var INSTANCE: RoomCommandWorkDatabase? = null

        fun getDatabase(appContext: Context): RoomCommandWorkDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext, RoomCommandWorkDatabase::class.java,
                    RoomCommandWorkDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}