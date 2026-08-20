package com.brunorafael.taskflow.domain.respository

import com.brunorafael.taskflow.domain.model.Task
import java.util.UUID

interface TaskRepository {
    suspend fun getTasks(): Result<List<Task>>

    suspend fun createTask(task: Task): Result<Unit>

    suspend fun updateTask(task: Task): Result<Unit>

    suspend fun deleteTask(id: UUID): Result<Unit>
}