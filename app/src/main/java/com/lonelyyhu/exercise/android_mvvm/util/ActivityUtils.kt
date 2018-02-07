package com.lonelyyhu.exercise.android_mvvm.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by hulonelyy on 2017/12/28.
 */
class ActivityUtils {

    companion object {

        @JvmStatic
        fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, containerId: Int, tag: String?){

            val transaction = fragmentManager.beginTransaction()

            if (tag != null) {
                transaction.replace(containerId, fragment, tag)
                transaction.addToBackStack(tag)
            } else {
                transaction?.replace(containerId, fragment)
            }

            transaction?.commit()

        }




    }


}