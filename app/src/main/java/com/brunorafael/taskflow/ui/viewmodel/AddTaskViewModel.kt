package com.brunorafael.taskflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brunorafael.taskflow.domain.model.Task
import com.brunorafael.taskflow.domain.model.TaskType
import com.brunorafael.taskflow.domain.respository.TaskRepository
import com.brunorafael.taskflow.ui.state.AddTaskUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddTaskViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<AddTaskUiState>(AddTaskUiState.Idle)

    val uiState = _uiState.asStateFlow()

    fun onSaveTask(
        description: String,
        type: TaskType
    ) {
        _uiState.value = AddTaskUiState.Saving

        val task = Task(
            description = description,
            type = type
        )

        viewModelScope.launch {
            taskRepository
                .createTask(task)
                .onSuccess {
                    _uiState.value = AddTaskUiState.Success
                }
                .onFailure { error ->
                    _uiState.value = AddTaskUiState.Error(
                        message = error.message
                    )
                }
        }
    }
}