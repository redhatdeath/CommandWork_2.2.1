package ru.shanin.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.shanin.data.entity.RoomWorkEntity.Companion.COL_WORK_ID
import ru.shanin.data.entity.RoomWorkEntity.Companion.NAME_TABLE
import ru.shanin.domain.entity.WorkInfo


@Entity(
    tableName = NAME_TABLE,
    indices = [
        Index(value = [COL_WORK_ID], unique = true)
    ]
)
data class RoomWorkEntity(

    @ColumnInfo(name = COL_WORK_NAME)
    val nameWork: String,

    @ColumnInfo(name = COL_PEOPLES)
    val workListPeopleId: String,

    @ColumnInfo(name = COL_IS_START)
    var isCommandWorkStart: Boolean,

    @ColumnInfo(name = COL_TIME_START)
    val timeStart: Long,

    @ColumnInfo(name = COL_IS_FINISH)
    var isCommandWorkFinish: Boolean,

    @ColumnInfo(name = COL_TIME_WORK)
    var workTime: Int = WorkInfo.TIME_BY_DEFAULT,

    @ColumnInfo(name = COL_WORK_ID)
    val id: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_WORK_ROW_ID)
    var row_id: Int = DEFAULT_ROW_ID

) {
    companion object {
        const val DEFAULT_ROW_ID = -1

        const val NAME_TABLE = "work"

        const val COL_WORK_ROW_ID = "work_row_id"

        const val COL_WORK_NAME = "work_name"
        const val COL_PEOPLES = "peoples"
        const val COL_IS_START = "isStart"
        const val COL_TIME_START = "timeStart"
        const val COL_IS_FINISH = "isFinish"
        const val COL_TIME_WORK = "timeWork"
        const val COL_WORK_ID = "work_id"


    }
}