package ru.shanin.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.People

interface PeopleRepository {
    fun addPeople(people: People)
    fun editPeople(people: People)
    fun getPeople(peopleId: Int): People
    fun getPeopleList(): MutableLiveData<List<People>>
}