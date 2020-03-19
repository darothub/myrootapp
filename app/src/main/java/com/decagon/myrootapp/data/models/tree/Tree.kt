package com.decagon.myrootapp.data.models.tree


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Tree(
    var country: String,
    var createdAt: String,
    @SerializedName("_id")
    var id: String,
    var latitude: Int,
    var locationType: String,
    var longitude: Int,
    var picture: String,
    var reason: @RawValue Reason? = null,
    var treeType: String,
    var updatedAt: String,
    var userid: String,
    @SerializedName("__v")
    var v: Int
):Parcelable