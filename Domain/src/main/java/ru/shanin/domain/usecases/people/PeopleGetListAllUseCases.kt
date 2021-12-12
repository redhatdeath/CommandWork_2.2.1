package ru.shanin.domain.usecases.people

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

class PeopleGetListAllUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    suspend fun peopleGetList(): MutableLiveData<List<People>> {
        return peopleDataRepository.getListOfAllPeople()
    }
}