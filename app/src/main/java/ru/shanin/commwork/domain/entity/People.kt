package ru.shanin.commwork.domain.entity

/**
 * sJHbvlSBligb
 */

data class People(
    val peopleInfo: PeopleInfo,
    val listOfWorkIds: List<Int>,
    var hasWorkInCommand: Boolean = NO_COMMAND,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        // const by default for new data objects
        const val UNDEFINED_ID = -1
        const val NO_COMMAND = false
    }
}