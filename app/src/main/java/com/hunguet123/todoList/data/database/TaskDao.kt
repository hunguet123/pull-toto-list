package com.hunguet123.todoList.data.database

import androidx.room.*
import com.hunguet123.todoList.data.Task


// tạo interface query
@Dao
interface TaskDao {

    @Query("SELECT * FROM taskTable")
    suspend fun getTasks(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}
