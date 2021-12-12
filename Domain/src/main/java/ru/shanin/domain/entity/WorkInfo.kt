package ru.shanin.domain.entity

data class WorkInfo(
    val workListPeopleId: List<Int>,
    var isCommandWorkStart: Boolean = NOT_START,
    val timeStart: Long,
    var isCommandWorkFinish: Boolean = NOT_FINISH,
    var workTime: Int = TIME_BY_DEFAULT
) {
    companion object {

        const val TIME_BY_DEFAULT = 60000  //in millis
        const val NOT_START = false
        const val NOT_FINISH = false

        fun setTimeStart(): Long {
            return System.currentTimeMillis()
        }
    }

}
