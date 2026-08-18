package com.brunorafael.taskflow.data.mapper

import com.brunorafael.taskflow.data.model.TaskEntity
import com.brunorafael.taskflow.domain.model.Task
import com.brunorafael.taskflow.domain.model.TaskType
import java.time.Instant
import java.util.UUID

class TaskMapper {

    fun toEntity(task: Task): TaskEntity {
        return TaskEntity(
            id = task.id.toString(),
            description = task.description,
            type = task.type.name,
            createdAt = task.createdAt.toString(),
            isCompleted = task.isCompleted
        )
    }

    fun toDomain(entity: TaskEntity): Task {
        return Task(
            id = UUID.fromString(entity.id),
            description = entity.description,
            type = TaskType.valueOf(entity.type),
            createdAt = Instant.parse(entity.createdAt),
            isCompleted = entity.isCompleted
        )
    }
}