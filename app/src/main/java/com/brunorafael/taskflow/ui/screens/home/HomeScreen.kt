package com.brunorafael.taskflow.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.brunorafael.taskflow.ui.components.AddTaskButton
import com.brunorafael.taskflow.ui.components.EmptyState
import com.brunorafael.taskflow.ui.components.HomeTopBar
import com.brunorafael.taskflow.ui.components.TaskItem
import com.brunorafael.taskflow.ui.state.HomeUiState
import com.brunorafael.taskflow.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddTaskClick: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            AddTaskButton(
                onClick = onAddTaskClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            val state = uiState.value

            when (state) {
                HomeUiState.Loading -> {
                    // Ainda não vamos implementar o Loading
                }

                HomeUiState.Empty -> {
                    EmptyState()
                }

                is HomeUiState.Success -> {
                    LazyColumn {
                        items(state.tasks) { task ->
                            TaskItem(task = task)
                        }
                    }
                }

                is HomeUiState.Error -> {
                    // Implementaremos depois
                }
            }
        }
    }
}