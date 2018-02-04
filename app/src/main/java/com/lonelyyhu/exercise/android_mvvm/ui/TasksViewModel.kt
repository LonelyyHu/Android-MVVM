package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.lonelyyhu.exercise.android_mvvm.TaskItemUserActionListener
import com.lonelyyhu.exercise.android_mvvm.data.Task
import com.lonelyyhu.exercise.android_mvvm.data.TasksRepository

/**
 * Created by hulonelyy on 2017/12/20.
 */
class TasksViewModel() : ViewModel(), TaskItemUserActionListener {


    var obStrNoTasksMessage = ObservableField<String>("No Task.....")
    var obStrFilteringLabel = ObservableField<String>("Filter Name")
    var obListTasks = ObservableArrayList<Task>()

    override fun onTaskClicked(task: Task) {
        Log.wtf("TasksViewModel", "onTaskClicked =>")
    }

    override fun onCompleteChanged(task: Task, view: View) {
        Log.wtf("TasksViewModel", "onCompleteChanged =>")
    }

    fun loadTasks() {
        obListTasks.clear()
        obListTasks.addAll(TasksRepository.getAllTask())
    }
}