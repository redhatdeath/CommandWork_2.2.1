package ru.shanin.commwork.domain.usecases.commandwork

import ru.shanin.commwork.domain.entity.CommandWork
import ru.shanin.commwork.domain.repository.CommandWorkRepository

class EditCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun editCommandWork(commandWork: CommandWork) {
        commandWorkRepository.editCommandWork(commandWork)
    }
}