package com.decagon.myrootapp.data.api

import com.decagon.myrootapp.constants.URLConstants
import com.decagon.myrootapp.constants.URLEndpoints
import com.decagon.myrootapp.data.models.auth.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthAPI {

    @POST(URLEndpoints.VERIFICATION_ENDPOINT)
    fun verifyAsync(
        @Body body: VerificationCode
    ): Deferred<VerificationResponse>

    @POST(URLEndpoints.FORGOT_PASSWORD_ENDPOINT)
    fun forgotPasswordAsync(
        @Body email: ForgotPasswordBody
    ): Deferred<ForgotPasswordResponse>


    @POST(URLEndpoints.RESET_PASSWORD_ENDPOINT)
    fun resetPasswordAsync(
        @Body request: ResetPasswordBody
    ): Deferred<ResetPasswordResponse>


    companion object{
        operator fun invoke(): AuthAPI{
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .build()
                .create(AuthAPI::class.java)
        }
    }
}