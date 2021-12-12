package ru.shanin.domain.entity

data class People(
    val peopleInfo: PeopleInfo,
    val listOfWorkIds: List<Int> = emptyListOfWorkIds,
    var hasWorkInCommand: Boolean = NO_COMMAND,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        // const by default for new data objects
        val emptyListOfWorkIds = listOf<Int>()
        const val UNDEFINED_ID = -1
        const val NO_COMMAND = false
    }
}