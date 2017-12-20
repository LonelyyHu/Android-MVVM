package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.lonelyyhu.exercise.android_mvvm.data.Task

/**
 * Created by hulonelyy on 2017/12/20.
 */
class TasksViewModel() : ViewModel() {

    companion object {

        @JvmField
        var obStrNoTasksMessage = ObservableField<String>()

        @JvmField
        var obBoolTasksListEmpty = ObservableBoolean(true)

        @JvmField
        var obStrFilteringLabel = ObservableField<String>()

        @JvmField
        var obListTasks = ObservableArrayList<Task>()



    }

}