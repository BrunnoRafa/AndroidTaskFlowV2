package com.brunorafael.taskflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brunorafael.taskflow.domain.respository.TaskRepository
import com.brunorafael.taskflow.ui.state.HomeErrorType
import com.brunorafael.taskflow.ui.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val taskRepository: TaskRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            val result = taskRepository.getTasks()

            result
                .onSuccess { tasks ->
                    _uiState.value =
                        if (tasks.isEmpty()) {
                            HomeUiState.Empty
                        } else {
                            HomeUiState.Success(tasks)
                        }
                }
                .onFailure {
                    _uiState.value = HomeUiState.Error(
                        HomeErrorType.UNKNOWN
                    )
                }
        }
    }

    fun onAddTaskClick() {
        // ainda vamos implementar
    }
}