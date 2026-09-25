package com.brunorafael.taskflow

import android.app.Application
import com.brunorafael.taskflow.data.mapper.TaskMapper
import com.brunorafael.taskflow.data.repository.TaskRepositoryImpl
import com.brunorafael.taskflow.di.DatabaseModule

class TaskFlowApplication : Application() {
    val database by lazy {
        DatabaseModule.provideDatabase(this)
    }
    val taskRepository by lazy {
        TaskRepositoryImpl(
            taskDao = database.taskDao(),
            taskMapper = TaskMapper()
        )
    }
}