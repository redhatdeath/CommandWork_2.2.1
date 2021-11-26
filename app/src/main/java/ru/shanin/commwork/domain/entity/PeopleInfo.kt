package ru.shanin.commwork.domain.entity

data class PeopleInfo(
    val firstName: String,
    val secondName: String,
    val phone: String,
    val email: String,
    val pathToPhoto: String,
    val listOfKnowledge: MutableSet<String>
)