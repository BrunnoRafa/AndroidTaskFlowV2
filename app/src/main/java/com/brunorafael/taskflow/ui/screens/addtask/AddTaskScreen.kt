package com.brunorafael.taskflow.ui.screens.addtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.brunorafael.taskflow.domain.model.TaskType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onBackClick: () -> Unit
) {
    var description by remember {
        mutableStateOf("")
    }

    var taskType by remember {
        mutableStateOf(TaskType.OTHER)
    }

    var typeMenuExpanded by remember {
        mutableStateOf(false)
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
        }
    }
}