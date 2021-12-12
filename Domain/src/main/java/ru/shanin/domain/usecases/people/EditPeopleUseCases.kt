package ru.shanin.domain.usecases.people

import ru.shanin.domain.repository.PeopleRepository
import ru.shanin.domain.entity.People

class EditPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun editPeople(people: People) {
        peopleRepository.editPeople(people)
    }
}