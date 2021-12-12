package ru.shanin.domain.usecases.work

import ru.shanin.domain.entity.Work
import ru.shanin.domain.repository.WorkDataRepository

class WorkAddNewUseCases(
    private val workDataRepository: WorkDataRepository
) {
    fun workAddNew(work: Work) {
        workDataRepository.addNewWork(work)
    }
}