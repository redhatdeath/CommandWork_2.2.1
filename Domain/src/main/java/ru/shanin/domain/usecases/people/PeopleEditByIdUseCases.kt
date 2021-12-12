package ru.shanin.domain.usecases.people

import ru.shanin.domain.entity.People
import ru.shanin.domain.repository.PeopleDataRepository

class PeopleEditByIdUseCases(
    private val peopleDataRepository: PeopleDataRepository
) {
    fun peopleEditById(people: People) {
        peopleDataRepository.editByIdPeople(people)
    }
}