package com.lonelyyhu.exercise.android_mvvm

import android.view.View
import com.lonelyyhu.exercise.android_mvvm.data.Task

/**
 * Created by hulonelyy on 2018/2/3.
 */
interface TaskItemUserActionListener {

    fun onTaskClicked(task: Task)

    fun onCompleteChanged(task: Task, view: View)


}