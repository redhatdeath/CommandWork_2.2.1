package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository

class WorkStartByIdUseCases(private val workDataRepository: WorkDataRepository) {
    fun workStartById(workId: Int) {
        workDataRepository.startByIdWork(workId)
    }
}