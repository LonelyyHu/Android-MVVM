package com.lonelyyhu.exercise.android_mvvm.data

import android.util.Log

/**
 * Created by hulonelyy on 2018/2/4.
 */
object TasksRepository {

    private val tasks = mutableListOf<Task>()

    init {
        Log.wtf("TasksRepository", "This ($this) is a singleton")
    }


    fun getAllTask() : List<Task> {
        return tasks
    }

    fun getTaskByID(id: Int): Task? {

        return if (id > 0 && id <= tasks.size) {
            tasks[id-1]
        } else {
            null
        }

    }

    fun addTask(task: Task) {

        task.id = tasks.size + 1
        tasks.add(task)
        Log.wtf("TasksRepository", "addTask => ${tasks.size}")

    }

    fun updateTask(task: Task) {

        tasks.set(task.id, task)

        Log.wtf("TasksRepository", "updateTask => ${task.id}")

    }


}