package com.decagon.myrootapp.data.models.tree


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Tree(
    var country: String? = null,
    var createdAt: String? = null,
    @SerializedName("_id")
    var id: String? = null,
    var latitude: Int? = null,
    var locationType: String? = null,
    var longitude: Int? = null,
    var picture: String? = null,
    var reason: @RawValue Reason? = null,
    var treeType: String? = null,
    var updatedAt: String? = null,
    var userid: String? = null,
    @SerializedName("__v")
    var v: Int? = null
):Parcelable