package ru.shanin.domain.entity

data class Work(
    var nameWork: String = DEFAULT_NAME,
    val workInfo: WorkInfo,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val DEFAULT_NAME = "Simply Work"
        const val UNDEFINED_ID = -1
    }


}


