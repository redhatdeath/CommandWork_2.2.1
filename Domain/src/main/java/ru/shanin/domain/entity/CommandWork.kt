package ru.shanin.domain.entity

data class CommandWork(
    var nameWork: String = DEFAULT_NAME,
    val workListPeopleId: List<Int>,
    var isCommandWorkStart: Boolean = NOT_START,
    val timeStart: Long,
    var isCommandWorkFinish: Boolean = NOT_FINISH,
    var workTime: Int = TIME_BY_DEFAULT,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val TIME_BY_DEFAULT = 60000  //in millis
        const val NOT_START = false
        const val NOT_FINISH = false
        const val DEFAULT_NAME = "Simply Work"
    }

    fun setTimeStart(): Long {
        return System.currentTimeMillis()
    }
}


