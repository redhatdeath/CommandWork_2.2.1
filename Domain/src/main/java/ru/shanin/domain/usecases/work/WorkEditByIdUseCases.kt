package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository

class WorkEditByIdUseCases(
    private val workDataRepository: WorkDataRepository
) {
    fun editCommandWork(workId: Int) {
        workDataRepository.editByIdWork(workId)
    }
}