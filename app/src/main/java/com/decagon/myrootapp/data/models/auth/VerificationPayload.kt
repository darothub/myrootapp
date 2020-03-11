package com.decagon.myrootapp.data.models.auth


import com.google.gson.annotations.SerializedName

data class VerificationPayload(
    var country: String,
    var createdAt: String,
    var email: String,
    @SerializedName("_id")
    var id: String,
    var isVerified: Boolean,
    var name: String,
    var password: String,
    var phone: String,
    var updatedAt: String,
    @SerializedName("__v")
    var v: Int
)