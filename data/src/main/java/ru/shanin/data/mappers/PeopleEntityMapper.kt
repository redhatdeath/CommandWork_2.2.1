package ru.shanin.commwork.data.mappers

import ru.shanin.commwork.data.entity.RoomPeopleEntity
import ru.shanin.domain.domain.entity.People
import ru.shanin.domain.domain.entity.PeopleInfo

class PeopleEntityMapper {
    fun toRoomPeopleEntity(people: ru.shanin.domain.domain.entity.People): RoomPeopleEntity {
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

    fun toPeople(roomPeopleEntity: RoomPeopleEntity): ru.shanin.domain.domain.entity.People {
        return ru.shanin.domain.domain.entity.People(
            peopleInfo = ru.shanin.domain.domain.entity.PeopleInfo(
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