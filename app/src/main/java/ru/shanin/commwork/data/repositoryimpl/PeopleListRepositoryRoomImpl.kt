package ru.shanin.commwork.data.repositoryimpl

import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository

object PeopleListRepositoryRoomImpl:PeopleRepository {
    private val peopleListLiveData = MutableLiveData<List<People>>()

    private var peopleList = sortedSetOf<People>(
        { p1, p2 ->
            val a = p1.peopleInfo.firstName.compareTo(p2.peopleInfo.firstName)
            val b = p1.peopleInfo.secondName.compareTo(p2.peopleInfo.secondName)
            when (a) {
                0 -> b
                else -> a
            }
        }
    )

    override fun addPeople(people: People) {
        TODO("Not yet implemented")
    }

    override fun editPeople(people: People) {
        TODO("Not yet implemented")
    }

    override fun getPeople(peopleId: Int): People {
        TODO("Not yet implemented")
    }

    override fun getPeopleList(): MutableLiveData<List<People>> {
        TODO("Not yet implemented")
    }

    //TODO sqlite3+Room to save peopleInfo and list of actual and finished works
}