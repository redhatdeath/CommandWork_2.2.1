package ru.shanin.commwork.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.shanin.commwork.data.entity.RoomPeopleEntity.Companion.COL_FIRST_NAME
import ru.shanin.commwork.data.entity.RoomPeopleEntity.Companion.COL_SECOND_NAME
import ru.shanin.commwork.data.entity.RoomPeopleEntity.Companion.NAME_TABLE

@Entity(
    tableName = NAME_TABLE,
    indices = [Index(value = [COL_FIRST_NAME, COL_SECOND_NAME], unique = true)]
)
data class RoomPeopleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_PEOPLE_ROW_ID) var row_id: Int = DEFAULT_ROW_ID,

    @ColumnInfo(name = COL_PEOPLE_ID) val peopleId: Int,
    @ColumnInfo(name = COL_FIRST_NAME) val firstName: String,
    @ColumnInfo(name = COL_SECOND_NAME) val secondName: String,
    @ColumnInfo(name = COL_PHONE) val phone: String,
    @ColumnInfo(name = COL_EMAIL) val email: String,
    @ColumnInfo(name = COL_PATH_TO_PHOTO) val pathToPhoto: String,
    @ColumnInfo(name = COL_LIST_OF_KNOWLEDGE) val listOfKnowledge: String,
    @ColumnInfo(name = COL_LIST_OF_WORK_ID) val listOfWorkIds: String


) {
    companion object {
        const val DEFAULT_ROW_ID = 0

        const val NAME_TABLE = "people"

        const val COL_PEOPLE_ROW_ID = "people_row_id"

        const val COL_PEOPLE_ID = "people_id"
        const val COL_FIRST_NAME = "first_name"
        const val COL_SECOND_NAME = "second_name"
        const val COL_PHONE = "phone"
        const val COL_EMAIL = "email"
        const val COL_PATH_TO_PHOTO = "pathToPhoto"
        const val COL_LIST_OF_KNOWLEDGE = "listOfKnowledge"
        const val COL_LIST_OF_WORK_ID = "listOfWorkIds"


    }
}