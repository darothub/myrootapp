package com.decagon.myrootapp.data.repositories

import com.decagon.myrootapp.constants.URLConstants
import com.decagon.myrootapp.constants.URLEndpoints
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginAPI {

    @POST(URLEndpoints.USER_LOGIN_ENDPOINT)
    fun loginAsync(
        @Body body: LoginBody
    ): Deferred<LoginResponse>

    companion object{
        fun invoke(): LoginAPI{
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .build()
                .create(LoginAPI::class.java)
        }
    }
}