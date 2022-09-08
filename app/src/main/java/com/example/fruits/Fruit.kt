package com.example.app3

import android.os.Parcel
import android.os.Parcelable

data class Fruit(
    val name: String?,
    val image: Int,
    val describtion: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(describtion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruit> {
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }
}