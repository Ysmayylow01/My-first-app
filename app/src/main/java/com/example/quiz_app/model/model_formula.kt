package com.example.quiz_app.model

import android.os.Parcel
import android.os.Parcelable



class model_formula(val image:Int, val name:String, val at:String, val form:Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!,

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(at)
        parcel.writeInt(form)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<model_formula> {
        override fun createFromParcel(parcel: Parcel): model_formula {
            return model_formula(parcel)
        }

        override fun newArray(size: Int): Array<model_formula?> {
            return arrayOfNulls(size)
        }
    }
}


