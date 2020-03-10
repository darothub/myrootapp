package com.decagon.myrootapp.data.repositories

import com.decagon.myrootapp.constants.URLConstants
import com.decagon.myrootapp.constants.URLEndpoints
import com.decagon.myrootapp.data.models.tree.Tree
import com.decagon.myrootapp.data.models.tree.TreeResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TreeAPI {

    @GET(URLEndpoints.TREE_ENDPOINT)
    fun getAllTreesAsync(): Deferred<TreeResponse>

    @POST(URLEndpoints.TREE_ENDPOINT)
    fun createTreeAsync(
        @Field("body") tree: Tree
    ): Deferred<TreeResponse>

    @GET(URLEndpoints.SINGLE_TREE_ENDPOINT)
    fun getTreeByIdAsync(
        @Path("id") id: String
    ): Deferred<TreeResponse>

    @GET(URLEndpoints.USER_TREE_ENDPOINT)
    fun getUserTreeAsync(
        //TODO
    )

    companion object{
        fun invoke(): TreeAPI{
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConstants.BASE_URL)
                .build()
                .create(TreeAPI::class.java)
        }
    }
}