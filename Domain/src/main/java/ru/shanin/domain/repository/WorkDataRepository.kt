package ru.shanin.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.Work

interface WorkDataRepository {
    fun addNewWork(work: Work)
    fun editByIdWork(workId: Int)
    fun removeByIdWork(workId: Int)
    fun getByIdWork(workId: Int): Work
    fun startByIdWork(workId: Int)
    fun finishByIdWork(workId: Int)
    fun pauseByIdWork(workId: Int)
    suspend fun getListOfAllWork(): MutableLiveData<List<Work>>
    suspend fun getListByIdsWork(workIds: IntArray): MutableLiveData<List<Work>>
}