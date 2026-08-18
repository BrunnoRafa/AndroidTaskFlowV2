package com.brunorafael.taskflow.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey
    val id: String,
    val description: String,
    val type: String,
    val createdAt: String,
    var isCompleted: Boolean
)