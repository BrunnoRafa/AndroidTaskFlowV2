package com.brunorafael.taskflow.ui.state

import com.brunorafael.taskflow.domain.model.Task

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data object Empty : HomeUiState()
    data class Success(
        val tasks: List<Task>
    ) : HomeUiState()
    data class Error(
        val type: HomeErrorType
    ) : HomeUiState()
}