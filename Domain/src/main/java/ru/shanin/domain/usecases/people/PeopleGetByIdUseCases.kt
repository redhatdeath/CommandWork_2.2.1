package ru.shanin.domain.usecases.people

import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

class PeopleGetByIdUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    fun peopleGetById(peopleId: Int): People {
        return peopleDataRepository.getByIdPeople(peopleId)
    }

}