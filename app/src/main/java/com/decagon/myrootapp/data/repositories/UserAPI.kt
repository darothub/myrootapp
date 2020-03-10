package com.decagon.myrootapp.data.repositories

import com.decagon.myrootapp.constants.URLConstants
import com.decagon.myrootapp.constants.URLEndpoints
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserAPI {

    @POST(URLEndpoints.USER_ENDPOINT)
    fun addUser(
        @Field("body") user: UserBody
    ): Deferred<UserResponse>


    companion object{
        fun invoke(): UserAPI{
            val okHttpClient = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(URLConstants.BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(UserAPI::class.java)
        }
    }
}