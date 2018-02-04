package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.lonelyyhu.exercise.android_mvvm.data.Task
import com.lonelyyhu.exercise.android_mvvm.data.TasksRepository

/**
 * Created by hulonelyy on 2018/2/3.
 */
class TasksDetailViewModel: ViewModel() {

    var obBoolCompleted = ObservableBoolean(false)
    var obStrTitle = ObservableField<String>("title")
    var obStrDescription = ObservableField<String>("description")

    var task: Task? = null

    fun start(taskId: Int) {
        task = TasksRepository.getTaskByID(taskId)

        task?.let {
            obBoolCompleted.set(it.completed)
            obStrTitle.set(it.title)
            obStrDescription.set(it.description)
        }

    }

    fun onClickSubmit(view: View) {
        Log.wtf("TasksDetailViewModel", "onClickSubmit =>")

        val newTask = task ?: Task()
        newTask.title = obStrTitle.get()
        newTask.description = obStrDescription.get()
        newTask.completed = obBoolCompleted.get()

        if (task == null) {
            TasksRepository.addTask(newTask)
        } else {
            TasksRepository.updateTask(newTask)
        }

    }



}