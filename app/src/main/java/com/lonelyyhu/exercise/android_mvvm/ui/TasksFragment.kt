package com.lonelyyhu.exercise.android_mvvm.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lonelyyhu.exercise.android_mvvm.R
import com.lonelyyhu.exercise.android_mvvm.databinding.FragmentTasksBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TasksFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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

        return binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }



}
