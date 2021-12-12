package ru.shanin.domain.usecases.people

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

class PeopleGetListByIdsUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    suspend fun peopleGetListByIds(peopleIds: IntArray): MutableLiveData<List<People>> {
        return peopleDataRepository.getListByIdsPeople(peopleIds)
    }
}