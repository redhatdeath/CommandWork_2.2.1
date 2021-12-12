package ru.shanin.domain.usecases.commandwork

import ru.shanin.domain.entity.CommandWork
import ru.shanin.domain.repository.CommandWorkRepository

class EditCommandWorkUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun editCommandWork(commandWork: CommandWork) {
        commandWorkRepository.editCommandWork(commandWork)
    }
}