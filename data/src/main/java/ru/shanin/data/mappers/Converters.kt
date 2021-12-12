package ru.shanin.data.mappers

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromListOfKnowledgeToString(listOfKnowledge: MutableSet<String>): String {
        return listOfKnowledge.joinToString { "," }
    }

    @TypeConverter
    fun fromStringToListOfKnowledge(listOfKnowledge: String): MutableSet<String> {
        return mutableSetOf(
            listOfKnowledge.split(",")
                .toString()
        )
    }

    @TypeConverter
    fun fromListOfWorkIdsToString(listOfWorkIds: List<Int>): String {
        return listOfWorkIds.joinToString { "," }
    }

    @TypeConverter
    fun fromStringToListOfWorkIds(listOfWorkIds: String): List<Int> {
        return listOfWorkIds
            .split(",")
            .filterNot { it.isBlank() }
            .map { it.toInt() }
    }
}