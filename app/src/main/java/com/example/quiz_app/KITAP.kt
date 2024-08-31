package com.example.quiz_app

import android.os.Parcel
import android.os.Parcelable

data class KITAP (val image:Int, val name:String, val pdf:String, val awtor:String) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(pdf)
        parcel.writeString(awtor)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<KITAP> {
        override fun createFromParcel(parcel: Parcel): KITAP {
            return KITAP(parcel)
        }

        override fun newArray(size: Int): Array<KITAP?> {
            return arrayOfNulls(size)
        }
    }
}


