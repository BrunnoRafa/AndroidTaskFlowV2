package com.brunorafael.taskflow

//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.brunorafael.taskflow.ui.screens.home.HomeScreen
import com.brunorafael.taskflow.ui.viewmodel.HomeViewModelFactory

@Composable
fun TaskFlowApp() {
    val application = LocalContext.current.applicationContext as TaskFlowApplication
    val factory = HomeViewModelFactory(
        taskRepository = application.taskRepository
    )
//    val viewModel: HomeViewModel = viewModel()
    HomeScreen()
}

