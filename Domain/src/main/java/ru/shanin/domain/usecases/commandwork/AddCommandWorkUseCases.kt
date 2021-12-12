package ru.shanin.domain.usecases.commandwork

import ru.shanin.domain.repository.CommandWorkRepository
import ru.shanin.domain.entity.CommandWork

class AddCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun addCommandWork(commandWork: CommandWork) {
        commandWorkRepository.addCommandWork(commandWork)
    }
}