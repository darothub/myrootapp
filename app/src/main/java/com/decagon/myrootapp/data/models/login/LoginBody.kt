package com.decagon.myrootapp.data.models.login


import com.google.gson.annotations.SerializedName

data class LoginBody(
    var email: String,
    var password: String
)