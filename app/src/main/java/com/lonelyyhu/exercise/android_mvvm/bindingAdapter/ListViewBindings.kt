package com.lonelyyhu.exercise.android_mvvm.bindingAdapter

import android.databinding.BindingAdapter
import android.widget.ListView
import com.lonelyyhu.exercise.android_mvvm.adapter.TasksAdapter
import com.lonelyyhu.exercise.android_mvvm.data.Task

/**
 * Created by hulonelyy on 2017/12/27.
 */

class ListViewBindings {

    companion object {

        @JvmStatic
        @BindingAdapter("app:items")
        fun setItems(listView: ListView, items: List<Task>) {
            val adapter = listView.adapter as TasksAdapter

            adapter.swap(items)

        }

    }



}

