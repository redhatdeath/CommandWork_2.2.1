package ru.shanin.data.mappers

import ru.shanin.data.entity.RoomCommandWorkEntity
import ru.shanin.domain.entity.CommandWork


class CommandWorkEntityMapper {
    fun toRoomCommandWorkEntity(commandWork: CommandWork): RoomCommandWorkEntity {
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

    fun toCommandWork(roomCommandWorkEntity: RoomCommandWorkEntity): CommandWork {
        return CommandWork(
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