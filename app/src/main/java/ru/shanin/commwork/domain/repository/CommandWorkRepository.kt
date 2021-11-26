package ru.shanin.commwork.domain.repository

import androidx.lifecycle.MutableLiveData
import ru.shanin.commwork.domain.entity.CommandWork

interface CommandWorkRepository {
    fun addCommandWork(commandWork: CommandWork)
    fun editCommandWork(commandWork: CommandWork)
    fun getCommandWork(commandWorkId: Int): CommandWork
    fun getCommandWorkList(): MutableLiveData<List<CommandWork>>
}