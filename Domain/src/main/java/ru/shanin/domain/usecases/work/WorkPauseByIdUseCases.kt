package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository

class WorkPauseByIdUseCases(
    private val workDataRepository: WorkDataRepository
) {
    fun workPauseById(workId: Int) {
        workDataRepository.pauseByIdWork(workId)
    }
}