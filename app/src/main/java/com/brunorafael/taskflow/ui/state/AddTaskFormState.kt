package com.brunorafael.taskflow.ui.state

import com.brunorafael.taskflow.domain.model.TaskType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AddTaskFormState(
    val description: String = "",
    val taskType: TaskType = TaskType.OTHER
) {
    private  val _formState = MutableStateFlow(AddTaskFormState())
    val formState = _formState.asStateFlow()
}