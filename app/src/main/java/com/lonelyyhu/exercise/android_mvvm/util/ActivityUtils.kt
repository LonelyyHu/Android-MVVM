package com.lonelyyhu.exercise.android_mvvm.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by hulonelyy on 2017/12/28.
 */
class ActivityUtils {

    companion object {

        @JvmStatic
        fun replaceFragment(fragmentManager: FragmentManager?, fragment: Fragment?, containerId: Int){

            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(containerId, fragment)
            transaction?.commit()

        }




    }


}