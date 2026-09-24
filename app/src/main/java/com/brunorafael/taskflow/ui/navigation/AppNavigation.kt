package com.brunorafael.taskflow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brunorafael.taskflow.TaskFlowApplication
import com.brunorafael.taskflow.ui.screens.addtask.AddTaskScreen
import com.brunorafael.taskflow.ui.screens.home.HomeScreen
import com.brunorafael.taskflow.ui.viewmodel.HomeViewModel
import com.brunorafael.taskflow.ui.viewmodel.HomeViewModelFactory

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val application =
        LocalContext.current.applicationContext as TaskFlowApplication

    val factory = HomeViewModelFactory(
        taskRepository = application.taskRepository
    )

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            val viewModel: HomeViewModel = viewModel(
                factory = factory
            )

            HomeScreen(
                viewModel = viewModel,
                onAddTaskClick = {
                    navController.navigate("addTask")
                }
            )
        }

        composable("addTask") {
            AddTaskScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}