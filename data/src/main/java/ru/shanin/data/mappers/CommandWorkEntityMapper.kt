package ru.shanin.data.mappers

import ru.shanin.data.entity.RoomWorkEntity
import ru.shanin.domain.entity.Work
import ru.shanin.domain.entity.WorkInfo


class CommandWorkEntityMapper {
    fun toRoomWorkEntity(work: Work): RoomWorkEntity {
        return RoomWorkEntity(
            nameWork = work.nameWork,
            workListPeopleId = work.workInfo.workListPeopleId.joinToString { "," },
            isCommandWorkStart = work.workInfo.isCommandWorkStart,
            timeStart = work.workInfo.timeStart,
            isCommandWorkFinish = work.workInfo.isCommandWorkFinish,
            workTime = work.workInfo.workTime,
            id = work.id
        )
    }

    fun toWork(roomWorkEntity: RoomWorkEntity): Work {
        return Work(
            nameWork = roomWorkEntity.nameWork,
            workInfo = WorkInfo(
                workListPeopleId = roomWorkEntity.workListPeopleId
                    .split(",")
                    .filterNot { it.isBlank() }
                    .map { it.toInt() },
                isCommandWorkStart = roomWorkEntity.isCommandWorkStart,
                timeStart = roomWorkEntity.timeStart,
                isCommandWorkFinish = roomWorkEntity.isCommandWorkFinish,
                workTime = roomWorkEntity.workTime
            ),
            id = roomWorkEntity.id
        )
    }
}