package ru.shanin.domain.usecases.commandwork

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.CommandWork
import ru.shanin.domain.repository.CommandWorkRepository

class GetCommandWorkListUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun getCommandWorkList(): MutableLiveData<List<CommandWork>> {
        return commandWorkRepository.getCommandWorkList()
    }
}