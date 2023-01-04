package com.hunguet123.todoList.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hunguet123.todoList.data.Task

//https://developer.android.com/training/data-storage/room/prepopulate#kotlin
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    // static một object duy nhất
    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "Sample.db")
                //.createFromAsset("database/myapp.db")
                .build()
        }
    }
}
