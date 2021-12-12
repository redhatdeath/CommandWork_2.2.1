package ru.shanin.commwork.data.database

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListOfKnowledge(value: MutableSet<String>): String {
        return value.joinToString { "," }
    }

    @TypeConverter
    fun toListOfKnowledge(value: String): MutableSet<String> {
        return mutableSetOf(value.split(",").toString())
    }

    @TypeConverter
    fun fromListOfCommandWorkId(value: List<Int>): String {
        return value.joinToString { "," }
    }

    @TypeConverter
    fun toListOfCommandWorkId(value: String): List<Int> {
        return value.split(",").filterNot { it.isBlank() }.map { it.toInt() }
    }
}