package com.hunguet123.todoList.di

import android.app.Application
import com.hunguet123.todoList.data.database.AppDatabase
import com.hunguet123.todoList.data.repository.TaskRepository
import com.hunguet123.todoList.data.repository.TaskRepositoryImpl
import com.hunguet123.todoList.ui.add.AddViewModel
import com.hunguet123.todoList.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

// điều khiển koin
// khi dungf koin cần them name vào androidManifest.xml
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(viewModelModule, dataModule)
        }
    }
}
