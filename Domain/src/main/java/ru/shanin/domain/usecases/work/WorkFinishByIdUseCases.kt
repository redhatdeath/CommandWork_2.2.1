package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository

class WorkFinishByIdUseCases(
    private val workDataRepository: WorkDataRepository
) {
    fun workFinishById(workId: Int) {
        workDataRepository.finishByIdWork(workId)
    }
}