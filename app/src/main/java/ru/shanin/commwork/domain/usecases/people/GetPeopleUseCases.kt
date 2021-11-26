package ru.shanin.commwork.domain.usecases.people

import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

class GetPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun getPeople(peopleId: Int): People {
        return peopleRepository.getPeople(peopleId)
    }

}