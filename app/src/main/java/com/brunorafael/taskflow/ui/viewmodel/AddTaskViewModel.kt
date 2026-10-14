package com.brunorafael.taskflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brunorafael.taskflow.domain.model.Task
import com.brunorafael.taskflow.domain.model.TaskType
import com.brunorafael.taskflow.domain.respository.TaskRepository
import com.brunorafael.taskflow.ui.state.AddTaskFormState
import com.brunorafael.taskflow.ui.state.AddTaskUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddTaskViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<AddTaskUiState>(AddTaskUiState.Idle)

    private val _formState =
        MutableStateFlow(AddTaskFormState())

    val uiState = _uiState.asStateFlow()

    val formState = _formState.asStateFlow()

    fun onSaveTask() {
        val form = _formState.value

        if (form.description.isBlank()) {
            _uiState.value = AddTaskUiState.ValidationError(
                message = "A descrição não pode estar vazia"
            )
            return
        }

        _uiState.value = AddTaskUiState.Saving

        val task = Task(
            description = form.description,
            type = form.taskType
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

    fun onDescriptionChanged(description: String) {
        _formState.value = _formState.value.copy(
            description = description
        )
    }

    fun onTaskTypeChanged(taskType: TaskType) {
        _formState.value = _formState.value.copy(
            taskType = taskType
        )
    }
}