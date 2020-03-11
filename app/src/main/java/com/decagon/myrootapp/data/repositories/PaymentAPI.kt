package com.decagon.myrootapp.data.repositories

import com.decagon.myrootapp.constants.URLConstants
import com.decagon.myrootapp.constants.URLEndpoints
import com.decagon.myrootapp.data.models.payment.Payment
import com.decagon.myrootapp.data.models.payment.PaymentResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface PaymentAPI {

    @POST(URLEndpoints.PAYMENT_ENDPOINT)
    fun makePaymentAsync(
        @Body payment: Payment
    ): Deferred<PaymentResponse>

    @PUT(URLEndpoints.PAYMENT_UPDATE_ENDPOINT)
    fun updatePaymentAsync(): Deferred<PaymentResponse>

    @PUT(URLEndpoints.PAYMENT_UPDATE_STATUS_ENDPOINT)
    fun updatePaymentStatusAsync(): Deferred<PaymentResponse>

    companion object{
        fun invoke(): PaymentAPI{
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .build()
                .create(PaymentAPI::class.java)
        }
    }
}