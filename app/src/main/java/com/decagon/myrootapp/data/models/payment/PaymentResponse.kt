package com.decagon.myrootapp.data.models.payment


data class PaymentResponse(
    var message: String,
    var payload: PaymentPayload,
    var status: Int
)