package com.brunorafael.taskflow.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brunorafael.taskflow.TaskFlowApplication
import com.brunorafael.taskflow.ui.screens.addtask.AddTaskScreen
import com.brunorafael.taskflow.ui.screens.home.HomeScreen
import com.brunorafael.taskflow.ui.viewmodel.AddTaskViewModel
import com.brunorafael.taskflow.ui.viewmodel.AddTaskViewModelFactory
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

        composable("addTask") { backStackEntry ->

            val homeBackStackEntry =
                remember(backStackEntry) {
                    navController.getBackStackEntry("home")
                }

            val homeViewModel: HomeViewModel = viewModel(
                viewModelStoreOwner = homeBackStackEntry,
                factory = factory
            )

            val addTaskFactory = AddTaskViewModelFactory(
                taskRepository = application.taskRepository
            )

            val addTaskViewModel: AddTaskViewModel = viewModel(
                factory = addTaskFactory
            )

            AddTaskScreen(
                addTaskViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}