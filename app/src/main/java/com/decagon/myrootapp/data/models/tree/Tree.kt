package com.decagon.myrootapp.data.models.tree


import com.google.gson.annotations.SerializedName

data class Tree(
    var country: String,
    var createdAt: String,
    @SerializedName("_id")
    var id: String,
    var latitude: Int,
    var locationType: String,
    var longitude: Int,
    var picture: String,
    var reason: Reason,
    var treeType: String,
    var updatedAt: String,
    var userid: String,
    @SerializedName("__v")
    var v: Int
)