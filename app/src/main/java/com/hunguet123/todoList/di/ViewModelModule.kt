package com.hunguet123.todoList.di

import com.hunguet123.todoList.ui.add.AddViewModel
import com.hunguet123.todoList.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel()
    }
    viewModel {
        AddViewModel()
    }
}