package com.decagon.myrootapp.data.models.payment


import com.google.gson.annotations.SerializedName

data class Payment(
    var amount: Int,
    var currency: String,
    @SerializedName("customer_email")
    var customerEmail: String,
    @SerializedName("customer_phone")
    var customerPhone: String,
    var transactionId: String,
    var txref: String,
    var userId: String
)