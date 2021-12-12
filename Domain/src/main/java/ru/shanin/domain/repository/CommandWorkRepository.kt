package ru.shanin.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.domain.entity.CommandWork

interface CommandWorkRepository {
    fun addCommandWork(commandWork: CommandWork)
    fun editCommandWork(commandWork: CommandWork)
    fun getCommandWork(commandWorkId: Int): CommandWork
    fun getCommandWorkList(): MutableLiveData<List<CommandWork>>
}