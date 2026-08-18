package com.brunorafael.taskflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.brunorafael.taskflow.ui.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()
}