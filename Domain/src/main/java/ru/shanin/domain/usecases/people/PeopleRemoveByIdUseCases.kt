package ru.shanin.domain.usecases.people

import ru.shanin.domain.repository.PeopleDataRepository

class PeopleRemoveByIdUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    fun peopleRemoveById(peopleId: Int) {
        peopleDataRepository.removeByIdPeople(peopleId)
    }

}