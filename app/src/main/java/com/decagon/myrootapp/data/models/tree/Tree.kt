package com.decagon.myrootapp.data.models.tree


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Tree(
    var country: String? = null,
    var date: String? = null,
    var email: String? = null,
    var latitude: Int? = null,
    var location: String? = null,
    var locationType: String? = null,
    var longitude: String? = null,
    var name: String? = null,
    var occassion: String? = null,
    var picture: String? = null,
    var reason: @RawValue Reason? = null,
    var treeType: String? = null
):Parcelable