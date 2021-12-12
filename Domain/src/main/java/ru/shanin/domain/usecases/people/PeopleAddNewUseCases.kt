package ru.shanin.domain.usecases.people

import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

class PeopleAddNewUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    fun peopleAddNew(people: People) {
        peopleDataRepository.addNewPeople(people)
    }
}