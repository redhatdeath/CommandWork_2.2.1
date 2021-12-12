package ru.shanin.domain.usecases.people

import ru.shanin.domain.repository.PeopleRepository
import ru.shanin.domain.entity.People

class AddPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun addPeople(people: People) {
        peopleRepository.addPeople(people)
    }
}