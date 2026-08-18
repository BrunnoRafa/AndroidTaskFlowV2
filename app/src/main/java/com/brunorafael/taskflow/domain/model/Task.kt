package com.brunorafael.taskflow.domain.model

import java.time.Instant
import java.util.UUID

data class Task(
    val id: UUID = UUID.randomUUID(),
    var description: String,
    var type: TaskType = TaskType.OTHER,
    val createdAt: Instant = Instant.now(),
    var isCompleted: Boolean = false
)
