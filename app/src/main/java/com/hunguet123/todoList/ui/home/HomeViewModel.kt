package com.hunguet123.todoList.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hunguet123.todoList.data.Task
import com.hunguet123.todoList.data.repository.TaskRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val taskRepository: TaskRepository by inject()

    val tasks = MutableLiveData<List<Task>>()
    val error = MutableLiveData<String>()

    fun getTasks() = viewModelScope.launch {
        try {
            tasks.value = taskRepository.getTasks().sortedByDescending { it.id }
        } catch (e: Exception) {
            error.value = e.message
        }
    }
}
