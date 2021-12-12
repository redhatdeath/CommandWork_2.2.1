package ru.shanin.domain.usecases.people

import ru.shanin.domain.repository.PeopleRepository
import ru.shanin.domain.entity.People

class GetPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun getPeople(peopleId: Int): People {
        return peopleRepository.getPeople(peopleId)
    }

}