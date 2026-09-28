package com.brunorafael.taskflow.ui.screens.addtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brunorafael.taskflow.domain.model.TaskType
import com.brunorafael.taskflow.ui.state.AddTaskUiState
import com.brunorafael.taskflow.ui.viewmodel.AddTaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    viewModel: AddTaskViewModel,
    onBackClick: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()

    var description by remember {
        mutableStateOf("")
    }

    var taskType by remember {
        mutableStateOf(TaskType.OTHER)
    }

    var typeMenuExpanded by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(uiState.value) {
        if (uiState.value is AddTaskUiState.Success) {
            onBackClick()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Adicionar tarefa")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = {
                    Text(text = "Descricao")
                }
            )

            OutlinedButton(
                onClick = {
                    typeMenuExpanded = true
                }
            ) {
                Text("Tipo: ${taskType.name}")
            }

            DropdownMenu(
                expanded = typeMenuExpanded,
                onDismissRequest = {
                    typeMenuExpanded = false
                }
            ) {
                TaskType.entries.forEach { type ->
                    DropdownMenuItem(
                        text = {
                            Text(type.name)
                        },
                        onClick = {
                            taskType = type
                            typeMenuExpanded = false
                        }
                    )
                }
            }

            Button(
                onClick = {
                    viewModel.onSaveTask(
                        description = description,
                        type = taskType
                    )
                }
            ) {
                Text("Salvar")
            }
        }
    }
}