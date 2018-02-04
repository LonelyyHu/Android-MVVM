package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lonelyyhu.exercise.android_mvvm.R
import com.lonelyyhu.exercise.android_mvvm.databinding.FragmentTaskDetailBinding


class TaskDetailFragment : Fragment() {

    private lateinit var tasksDetailViewModel: TasksDetailViewModel
    private var taskId = -1

    companion object {

        private const val ARG_TASK_ID = "ARG_TASK_ID"

        fun newInstance(taskID: Int?): TaskDetailFragment {
            val fragment = TaskDetailFragment()

            taskID?.let {
                val bundle = Bundle()
                bundle.putInt(ARG_TASK_ID, it)
            }

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasksDetailViewModel = ViewModelProviders.of(this).get(TasksDetailViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentTaskDetailBinding>(inflater, R.layout.fragment_task_detail, container, false)

        binding.viewmodel = tasksDetailViewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (arguments != null) {
            taskId = arguments.getInt(ARG_TASK_ID)
        }

        tasksDetailViewModel.start(taskId)
    }
}
