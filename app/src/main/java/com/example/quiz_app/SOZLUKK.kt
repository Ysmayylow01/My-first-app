package com.example.quiz_app

import android.os.Parcel
import android.os.Parcelable

data class SOZLUKK(val id: String, val en:String, val tm:String, val read:String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(en)
        parcel.writeString(tm)
        parcel.writeString(read)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SOZLUKK> {
        override fun createFromParcel(parcel: Parcel): SOZLUKK {
            return SOZLUKK(parcel)
        }

        override fun newArray(size: Int): Array<SOZLUKK?> {
            return arrayOfNulls(size)
        }
    }
}
