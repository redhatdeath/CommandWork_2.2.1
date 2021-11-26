package ru.shanin.commwork.domain.usecases.commandwork

import ru.shanin.commwork.domain.entity.CommandWork
import ru.shanin.commwork.domain.repository.CommandWorkRepository

class AddCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun addCommandWork(commandWork: CommandWork) {
        commandWorkRepository.addCommandWork(commandWork)
    }
}