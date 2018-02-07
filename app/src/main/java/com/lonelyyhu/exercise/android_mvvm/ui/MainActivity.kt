package com.lonelyyhu.exercise.android_mvvm.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.lonelyyhu.exercise.android_mvvm.R
import com.lonelyyhu.exercise.android_mvvm.component.ScrollChildSwipeRefreshLayout
import com.lonelyyhu.exercise.android_mvvm.data.Task
import com.lonelyyhu.exercise.android_mvvm.data.TasksRepository
import com.lonelyyhu.exercise.android_mvvm.util.ActivityUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

//            TasksRepository.addTask(getTask())
//            tasksViewModel.loadTasks()

            val detailFragment = TaskDetailFragment.newInstance(null)

            ActivityUtils.replaceFragment(supportFragmentManager, detailFragment, R.id.contentFrame, TaskDetailFragment::class.java.name)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        setupViewFragment()

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        Log.wtf("MainActivity", "onNavigationItemSelected => ${item.itemId}")

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setupViewFragment() {

        val taskFrag = supportFragmentManager.findFragmentById(R.id.contentFrame) as TasksFragment? ?: TasksFragment.newInstance()

        tasksViewModel = ViewModelProviders.of(this).get(TasksViewModel::class.java)
        taskFrag.taskViewModel = tasksViewModel
        ActivityUtils.replaceFragment(supportFragmentManager, taskFrag, R.id.contentFrame, null)

    }

    private fun getTask(): Task {

        val task = Task()
        task.id = Calendar.getInstance().timeInMillis.toInt()
        task.title = "title-${task.id}"
        task.description = "description-${task.id}"

        return task

    }
}
