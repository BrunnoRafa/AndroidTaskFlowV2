package com.brunorafael.taskflow.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brunorafael.taskflow.ui.components.AddTaskButton
import com.brunorafael.taskflow.ui.components.EmptyState
import com.brunorafael.taskflow.ui.components.HomeTopBar

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            AddTaskButton(
                onClick = {}
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            EmptyState()
        }
    }
}