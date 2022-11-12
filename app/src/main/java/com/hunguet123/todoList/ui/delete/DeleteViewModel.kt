package com.hunguet123.todoList.ui.delete

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hunguet123.todoList.data.Task
import com.hunguet123.todoList.data.repository.TaskRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeleteViewModel : ViewModel(), KoinComponent {
    private val taskRepository : TaskRepository by inject()
    val error = MutableLiveData<String>()
    val isDeleteSuccess = MutableLiveData<Boolean>()

    fun deleteItem(task: Task) = viewModelScope.launch {
        try {
            taskRepository.deleteTask(task)
            isDeleteSuccess.value = true
        } catch (err : Exception) {
            error.value = err.message
        }

    }
}