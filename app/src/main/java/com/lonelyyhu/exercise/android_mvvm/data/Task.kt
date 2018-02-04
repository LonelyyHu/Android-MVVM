package com.lonelyyhu.exercise.android_mvvm.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hulonelyy on 2017/12/21.
 */
class Task() : Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var id = 0

    var title = ""

    var description = ""

    var completed = false

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        title = parcel.readString()
        description = parcel.readString()
        completed = parcel.readByte() != 0.toByte()
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }

}