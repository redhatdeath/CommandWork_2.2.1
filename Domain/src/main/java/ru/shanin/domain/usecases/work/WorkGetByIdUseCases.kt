package ru.shanin.domain.usecases.work

import ru.shanin.domain.repository.WorkDataRepository
import ru.shanin.domain.entity.Work

class WorkGetByIdUseCases(
    private val workDataRepository: WorkDataRepository) {
    fun workGetById(workId: Int): Work {
        return workDataRepository.getByIdWork(workId)
    }

}