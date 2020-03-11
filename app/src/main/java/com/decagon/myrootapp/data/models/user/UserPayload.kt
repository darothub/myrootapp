package com.decagon.myrootapp.data.models.user


import com.google.gson.annotations.SerializedName

data class UserPayload(
    var country: String,
    var createdAt: String,
    var email: String,
    @SerializedName("_id")
    var id: String,
    var isVerified: Boolean,
    var name: String,
    var phone: String,
    var updatedAt: String,
    @SerializedName("__v")
    var v: Int
)