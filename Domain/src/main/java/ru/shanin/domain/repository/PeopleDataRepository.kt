package ru.shanin.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.People

interface PeopleDataRepository {
    fun addNewPeople(people: People)
    fun editByIdPeople(people: People)
    fun getByIdPeople(peopleId: Int): People
    fun removeByIdPeople(peopleId: Int)
    suspend fun getListByIdsPeople(peopleIds: IntArray): MutableLiveData<List<People>>
    suspend fun getListOfAllPeople(): MutableLiveData<List<People>>
}