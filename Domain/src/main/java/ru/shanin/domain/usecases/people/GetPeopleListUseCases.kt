package ru.shanin.domain.usecases.people

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.repository.PeopleRepository
import ru.shanin.domain.entity.People

class GetPeopleListUseCases(private val peopleRepository: PeopleRepository) {
    fun getPeopleList(): MutableLiveData<List<People>> {
        return peopleRepository.getPeopleList()
    }
}