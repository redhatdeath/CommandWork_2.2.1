package ru.shanin.commwork.data

import ru.shanin.domain.domain.entity.PeopleInfo


fun genRandomLowString(length: Int): String {
    val allowedLowChars = ('a'..'z')
    return (1..length)
        .map { allowedLowChars.random() }
        .joinToString("")
}

fun genRandomUpString(): String {
    val allowedUpChars = ('A'..'Z')
    return (1..1)
        .map { allowedUpChars.random() }
        .joinToString("")
}

fun genRandomNumString(): String {
    val allowedChars = ('0'..'9')
    return (1..9)
        .map { allowedChars.random() }
        .joinToString("")
}

fun genFirstName(): String {
    return genRandomUpString() + genRandomLowString(4)
}

fun genSecondName(): String {
    return genRandomUpString() + genRandomLowString(6)
}

fun genPhone(): String {
    return "+79${genRandomNumString()}"
}

fun genEmail(firstName: String, secondName: String): String {
    return "$firstName$secondName@${genRandomLowString(6)}.com"
}

fun genPathToPhoto(firstName: String, secondName: String): String {
    return "photo\\$firstName$secondName.png"
}

fun genKnowledge(): MutableSet<String> {
    val knowledge =
        setOf("Java", "Kotlin", "Lua", "Erlang", "Go", "C", "C++", "C#", "JS", "PHP", "Piton")
    val result = mutableSetOf<String>()
    for (i in 1 until 3)
        result.add(knowledge.elementAt((Math.random() * knowledge.size).toInt()))
    return result.toSortedSet()
}


fun genPeopleInfo(): ru.shanin.domain.domain.entity.PeopleInfo {
    val firstName = genFirstName()
    val secondName = genSecondName()
    return ru.shanin.domain.domain.entity.PeopleInfo(
        firstName,
        secondName,
        genPhone(),
        genEmail(firstName, secondName),
        genPathToPhoto(firstName, secondName),
        genKnowledge()
    )
}