package ru.shanin.commwork.data.mappers

import ru.shanin.commwork.data.entity.RoomCommandWorkEntity
import ru.shanin.domain.domain.entity.CommandWork

class CommandWorkEntityMapper {
    fun toRoomCommandWorkEntity(commandWork: ru.shanin.domain.domain.entity.CommandWork): RoomCommandWorkEntity {
        return RoomCommandWorkEntity(
            nameWork = commandWork.nameWork,
            workListPeopleId = commandWork.workListPeopleId.joinToString { "," },
            isCommandWorkStart = commandWork.isCommandWorkStart,
            timeStart = commandWork.timeStart,
            isCommandWorkFinish = commandWork.isCommandWorkFinish,
            workTime = commandWork.workTime,
            id = commandWork.id
        )
    }

    fun toCommandWork(roomCommandWorkEntity: RoomCommandWorkEntity): ru.shanin.domain.domain.entity.CommandWork {
        return ru.shanin.domain.domain.entity.CommandWork(
            nameWork = roomCommandWorkEntity.nameWork,
            workListPeopleId =
            roomCommandWorkEntity.workListPeopleId
                .split(",")
                .filterNot { it.isBlank() }
                .map { it.toInt() },
            isCommandWorkStart = roomCommandWorkEntity.isCommandWorkStart,
            timeStart = roomCommandWorkEntity.timeStart,
            isCommandWorkFinish = roomCommandWorkEntity.isCommandWorkFinish,
            workTime = roomCommandWorkEntity.workTime
        )
    }
}