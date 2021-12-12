package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository

class WorkRemoveByIdUseCases(
    private val workDataRepository: WorkDataRepository
) {
    fun workRemoveById(workId: Int) {
        return workDataRepository.removeByIdWork(workId)
    }

}