package com.hunguet123.todoList.data.repository

import com.hunguet123.todoList.data.Task


// dùng cho koin
interface TaskRepository {

    suspend fun getTasks(): List<Task>

    suspend fun addTask(task: Task)

    suspend fun deleteTask(task: Task?)
}
