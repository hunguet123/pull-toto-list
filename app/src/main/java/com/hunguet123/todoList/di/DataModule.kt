package com.hunguet123.todoList.di

import com.hunguet123.todoList.data.database.AppDatabase
import com.hunguet123.todoList.data.repository.TaskRepository
import com.hunguet123.todoList.data.repository.TaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase.getInstance(androidContext())
    }
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}