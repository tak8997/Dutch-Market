package com.mashup.dutchmarket.data

import android.os.Parcel
import android.os.Parcelable


data class PopularPost(val imageUrl: String, val postTitle: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeString(postTitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PopularPost> {
        override fun createFromParcel(parcel: Parcel): PopularPost {
            return PopularPost(parcel)
        }

        override fun newArray(size: Int): Array<PopularPost?> {
            return arrayOfNulls(size)
        }
    }
}