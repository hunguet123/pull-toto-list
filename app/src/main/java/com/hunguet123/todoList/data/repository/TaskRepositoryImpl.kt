package com.hunguet123.todoList.data.repository

import com.hunguet123.todoList.data.Task
import com.hunguet123.todoList.data.database.AppDatabase

class TaskRepositoryImpl(
    private val database: AppDatabase
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return database.taskDao().getTasks()
    }

    override suspend fun addTask(task: Task) {
        database.taskDao().insertTask(task)
    }

    override suspend fun deleteTask(task: Task?) {
        if (task != null) {
            database.taskDao().deleteTask(task)
        }
    }

}
