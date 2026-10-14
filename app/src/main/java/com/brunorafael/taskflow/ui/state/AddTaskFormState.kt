package com.brunorafael.taskflow.ui.state

import com.brunorafael.taskflow.domain.model.TaskType

data class AddTaskFormState(
    val description: String = "",
    val taskType: TaskType = TaskType.OTHER
)