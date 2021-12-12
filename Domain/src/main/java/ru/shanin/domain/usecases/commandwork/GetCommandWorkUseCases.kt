package ru.shanin.domain.usecases.commandwork

import ru.shanin.domain.repository.CommandWorkRepository
import ru.shanin.domain.entity.CommandWork

class GetCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun getCommandWork(commandWorkId: Int): CommandWork {
        return commandWorkRepository.getCommandWork(commandWorkId)
    }

}