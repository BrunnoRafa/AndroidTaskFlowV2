package com.brunorafael.taskflow.ui.state

sealed class AddTaskUiState {
    data object Idle : AddTaskUiState()

    data object Saving : AddTaskUiState()

    data object Success : AddTaskUiState()

    data class Error(
        val message: String? = null
    ) : AddTaskUiState()
}