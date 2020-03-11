package com.decagon.myrootapp.data.models.auth


data class VerificationResponse(
    var message: String,
    var payload: VerificationPayload,
    var status: Int,
    var token: String
)