package ru.shanin.commwork.domain.usecases.people

import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

class EditPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun editPeople(people: People) {
        peopleRepository.editPeople(people)
    }
}