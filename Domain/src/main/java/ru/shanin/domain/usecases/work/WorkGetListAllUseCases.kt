package ru.shanin.domain.usecases.work

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.Work
import ru.shanin.domain.repository.WorkDataRepository

class WorkGetListAllUseCases(
    private val workDataRepository: WorkDataRepository
) {
    suspend fun workGetListAll(): MutableLiveData<List<Work>> {
        return workDataRepository.getListOfAllWork()
    }
}