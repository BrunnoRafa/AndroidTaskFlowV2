package com.brunorafael.taskflow.data.repository

import com.brunorafael.taskflow.data.dao.TaskDao
import com.brunorafael.taskflow.data.mapper.TaskMapper
import com.brunorafael.taskflow.domain.model.Task
import com.brunorafael.taskflow.domain.respository.TaskRepository
import java.util.UUID

class TaskRepositoryImpl(
    private val taskDao: TaskDao,
    private val taskMapper: TaskMapper
) : TaskRepository {
    override suspend fun getTasks(): Result<List<Task>> {
        return runCatching {
            val entities = taskDao.getTasks()

            entities.map { entity ->
                taskMapper.toDomain(entity)
            }
        }
    }

    override suspend fun createTask(task: Task): Result<Unit> {
        return runCatching {
            val entity = taskMapper.toEntity(task)

            taskDao.insertTask(entity)
        }
    }

    override suspend fun updateTask(task: Task): Result<Unit> {
        return runCatching {
            val entity = taskMapper.toEntity(task)

            taskDao.updateTask(entity)
        }
    }

    override suspend fun deleteTask(id: UUID): Result<Unit> {
        return runCatching {
            taskDao.deleteTask(id.toString())
        }
    }
}