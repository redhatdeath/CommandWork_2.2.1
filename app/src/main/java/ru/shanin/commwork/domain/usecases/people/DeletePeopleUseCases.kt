package ru.shanin.commwork.domain.usecases.people

import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

class DeletePeopleUseCases(private val peopleRepository: PeopleRepository) {

    fun deletePeople(people: People) {
        peopleRepository.deletePeople(people)
    }
}