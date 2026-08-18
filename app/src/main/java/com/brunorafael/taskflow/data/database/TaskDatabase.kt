package com.brunorafael.taskflow.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brunorafael.taskflow.data.dao.TaskDao
import com.brunorafael.taskflow.data.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}