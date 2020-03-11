package com.decagon.myrootapp.data.models.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message: String,
    var payload: Payload,
    var status: Int,
    var token: String
)