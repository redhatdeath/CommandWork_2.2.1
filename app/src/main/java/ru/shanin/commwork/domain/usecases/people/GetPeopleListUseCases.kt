package ru.shanin.commwork.domain.usecases.people

import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

class GetPeopleListUseCases(private val peopleRepository: PeopleRepository) {
    fun getPeopleList(): MutableLiveData<List<People>> {
        return peopleRepository.getPeopleList()
    }
}