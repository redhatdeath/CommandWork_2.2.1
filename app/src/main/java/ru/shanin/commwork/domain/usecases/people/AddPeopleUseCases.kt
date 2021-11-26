package ru.shanin.commwork.domain.usecases.people

import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

class AddPeopleUseCases(private val peopleRepository: PeopleRepository) {
    fun addPeople(people: People) {
        peopleRepository.addPeople(people )
    }
}