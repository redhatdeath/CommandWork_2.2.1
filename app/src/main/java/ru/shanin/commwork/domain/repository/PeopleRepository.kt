package ru.shanin.commwork.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.People

interface PeopleRepository {
    fun addPeople(people: People)
    fun editPeople(people: People)
    fun getPeople(peopleId: Int): People
    fun getPeopleList(): MutableLiveData<List<People>>
}