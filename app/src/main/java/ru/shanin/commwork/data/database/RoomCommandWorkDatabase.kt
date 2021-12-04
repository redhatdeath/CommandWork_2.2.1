package ru.shanin.commwork.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shanin.commwork.data.entity.RoomCommandWorkEntity

@Database(entities = [RoomCommandWorkEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomCommandWorkDatabase : RoomDatabase() {
    abstract fun roomCommandWorkDao(): RoomCommandWorkDao

    companion object {
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