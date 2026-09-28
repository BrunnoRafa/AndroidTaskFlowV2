package com.brunorafael.taskflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brunorafael.taskflow.domain.respository.TaskRepository

class AddTaskViewModelFactory(
    private val taskRepository: TaskRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(AddTaskViewModel::class.java)) {
            return AddTaskViewModel(taskRepository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}