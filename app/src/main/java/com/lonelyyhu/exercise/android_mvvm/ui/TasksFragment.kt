package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.lonelyyhu.exercise.android_mvvm.R
import com.lonelyyhu.exercise.android_mvvm.adapter.TasksAdapter
import com.lonelyyhu.exercise.android_mvvm.databinding.FragmentTasksBinding


class TasksFragment : Fragment() {

    lateinit var taskViewModel: TasksViewModel


    companion object {

        fun newInstance(): TasksFragment {
            return TasksFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                     savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentTasksBinding>(inflater, R.layout.fragment_tasks, container, false)
        binding.viewmodel = taskViewModel

        val adapter = TasksAdapter(ViewModelProviders.of(activity).get(TasksViewModel::class.java))
        binding.lvTasksList.adapter = adapter
        binding.lvTasksList.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        return binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }



}
