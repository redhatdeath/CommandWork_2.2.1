package ru.shanin.commwork.domain.usecases.commandwork

import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.CommandWork
import ru.shanin.commwork.domain.repository.CommandWorkRepository

class GetCommandWorkListUseCases(private val commandWorkRepository: CommandWorkRepository) {
    fun getCommandWorkList(): MutableLiveData<List<CommandWork>> {
        return commandWorkRepository.getCommandWorkList()
    }
}