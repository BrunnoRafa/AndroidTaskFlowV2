package com.brunorafael.taskflow.di

import android.content.Context
import androidx.room.Room
import com.brunorafael.taskflow.data.database.TaskDatabase

object DatabaseModule {
    fun provideDatabase(context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDatabase::class.java,
            "taskflow.db"
        ).build()
    }
}