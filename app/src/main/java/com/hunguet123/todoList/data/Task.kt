package com.hunguet123.todoList.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// create table
@Entity(tableName = "taskTable")
data class Task(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "description")
    val description: String = ""
)
