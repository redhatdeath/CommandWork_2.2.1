package ru.shanin.commwork.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.People
import ru.shanin.commwork.domain.repository.PeopleRepository
import kotlin.random.Random


object PeopleRepositoryImpl : PeopleRepository {

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

    private var autoIncrementId = 0

    init {

        for (i in 1..500) {
            val people = People(genPeopleInfo(), Random.nextBoolean())
            addPeople(people)
        }
    }


    override fun addPeople(people: People) {
        if (people.id == People.UNDEFINED_ID)
            people.id = autoIncrementId++
        peopleList.add(people)
        updateList()
    }

    override fun deletePeople(people: People) {
        peopleList.remove(people)
        updateList()
    }

    override fun editPeople(people: People) {
        Log.d(
            "PeopleInfoViewModel",
            "edit people PeopleListRepositoryImpl = $people"
        )
        val oldPeople = getPeople(people.id)
        Log.d(
            "PeopleInfoViewModel",
            "old people PeopleListRepositoryImpl = $oldPeople"
        )
        peopleList.remove(oldPeople)
        addPeople(people)
    }

    override fun getPeople(peopleId: Int): People {
        return peopleList.find {
            it.id == peopleId
        } ?: throw  RuntimeException("Element with id $peopleId not found")
    }

    override fun getPeopleList(): MutableLiveData<List<People>> {
        return peopleListLiveData
    }

    private fun updateList() {
        peopleListLiveData.value = peopleList.toList()
    }
}