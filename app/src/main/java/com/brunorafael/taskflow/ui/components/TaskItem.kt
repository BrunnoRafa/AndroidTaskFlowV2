package com.brunorafael.taskflow.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.brunorafael.taskflow.domain.model.Task

@Composable
fun TaskItem(task: Task) {
    Text(
        text = task.description
    )
}