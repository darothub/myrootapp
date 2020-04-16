package com.decagon.myrootapp.data.models.user


import com.google.gson.annotations.SerializedName

data class UserBody(
    var country: String? = null,
    var email: String? = null,
    var isVerified: Boolean = false,
    var name: String? = null,
    var password: String? = null,
    var phone: String? = null
)