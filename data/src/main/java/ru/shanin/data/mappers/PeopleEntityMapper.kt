package ru.shanin.data.mappers

import ru.shanin.data.entity.RoomPeopleEntity

class PeopleEntityMapper {
    fun toRoomPeopleEntity(people: ru.shanin.domain.entity.People): RoomPeopleEntity {
        return RoomPeopleEntity(
            peopleId = people.id,
            firstName = people.peopleInfo.firstName,
            secondName = people.peopleInfo.secondName,
            phone = people.peopleInfo.phone,
            email = people.peopleInfo.email,
            pathToPhoto = people.peopleInfo.pathToPhoto,
            listOfKnowledge = people.peopleInfo.listOfKnowledge.joinToString { "," },
            listOfWorkIds = people.listOfWorkIds.joinToString { "," }
        )
    }

    fun toPeople(roomPeopleEntity: RoomPeopleEntity): ru.shanin.domain.entity.People {
        return ru.shanin.domain.entity.People(
            peopleInfo = ru.shanin.domain.entity.PeopleInfo(
                roomPeopleEntity.firstName,
                roomPeopleEntity.secondName,
                roomPeopleEntity.phone,
                roomPeopleEntity.email,
                roomPeopleEntity.pathToPhoto,
                mutableSetOf(
                    roomPeopleEntity.listOfKnowledge
                        .split(",")
                        .toString()
                )
            ),
            listOfWorkIds = roomPeopleEntity.listOfWorkIds
                .split(",")
                .filterNot { it.isBlank() }
                .map { it.toInt() },
            id = roomPeopleEntity.peopleId
        )
    }
}