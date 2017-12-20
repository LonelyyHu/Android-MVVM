package com.lonelyyhu.exercise.android_mvvm.component

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet
import android.view.View

/**
 * Created by hulonelyy on 2017/12/20.
 */
class ScrollChildSwipeRefreshLayout : SwipeRefreshLayout {

    lateinit var scrollUpChild: View

    constructor(context: Context?) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)


    override fun canChildScrollUp(): Boolean {

        return if (::scrollUpChild.isInitialized) {
            scrollUpChild.canScrollVertically(-1)
        } else {
            super.canChildScrollUp()
        }

    }
}