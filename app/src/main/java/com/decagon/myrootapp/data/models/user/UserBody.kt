package com.decagon.myrootapp.data.models.user


import com.google.gson.annotations.SerializedName

data class UserBody(
    var country: String,
    var email: String,
    var isVerified: Boolean,
    var name: String,
    var password: String,
    var phone: String
)