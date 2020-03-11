package com.decagon.myrootapp.data.models.user


import com.decagon.myrootapp.data.models.payment.Payment
import com.decagon.myrootapp.data.models.payment.PaymentPayload
import com.google.gson.annotations.SerializedName

data class UserResponse(
    var message: String,
    var payload: UserPayload,
    var status: Int,
    var token: String
)