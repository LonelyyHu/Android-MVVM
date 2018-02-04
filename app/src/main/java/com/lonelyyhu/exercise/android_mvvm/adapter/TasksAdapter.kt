package com.lonelyyhu.exercise.android_mvvm.adapter

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.lonelyyhu.exercise.android_mvvm.data.Task
import com.lonelyyhu.exercise.android_mvvm.databinding.TaskItemBinding
import com.lonelyyhu.exercise.android_mvvm.ui.TasksViewModel

/**
 * Created by hulonelyy on 2018/2/2.
 */
class TasksAdapter(val tasksViewModel: TasksViewModel) : BaseAdapter(){

    private val tasks = mutableListOf<Task>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val binding = if (convertView == null) {
            val inflater = LayoutInflater.from(parent?.context)
            TaskItemBinding.inflate(inflater, parent, false)
        } else {
            DataBindingUtil.getBinding(convertView) as TaskItemBinding
        }

        binding.task = tasks.get(position)
        binding.listener = tasksViewModel

        return binding.root
    }

    override fun getItem(position: Int): Task {
        return tasks.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return tasks.size
    }

    fun swap(newTasks: List<Task>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }


}