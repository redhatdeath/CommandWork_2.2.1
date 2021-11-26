package ru.shanin.commwork.domain.usecases.commandwork

import ru.shanin.commwork.domain.entity.CommandWork
import ru.shanin.commwork.domain.repository.CommandWorkRepository

class GetCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun getCommandWork(commandWorkId: Int): CommandWork {
        return commandWorkRepository.getCommandWork(commandWorkId)
    }

}