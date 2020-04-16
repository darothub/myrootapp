package com.decagon.myrootapp.data.models.user


import com.google.gson.annotations.SerializedName

data class UserPayload(
    var country: String? = null,
    var createdAt: String? = null,
    var email: String? = null,
    @SerializedName("_id")
    var id: String? = null,
    var isVerified: Boolean,
    var name: String? = null,
    var phone: String? = null,
    var updatedAt: String? = null,
    @SerializedName("__v")
    var v: Int? = null
)