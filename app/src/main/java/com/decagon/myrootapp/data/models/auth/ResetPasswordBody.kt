package com.decagon.myrootapp.data.models.auth

data class ResetPasswordBody(
    var email: String,
    var code: String,
    var password: String
)