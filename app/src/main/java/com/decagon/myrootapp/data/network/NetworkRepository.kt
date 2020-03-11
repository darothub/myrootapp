package com.decagon.myrootapp.data.network

import android.util.Log
import com.decagon.myrootapp.data.api.*
import com.decagon.myrootapp.data.models.auth.ResetPasswordBody
import com.decagon.myrootapp.data.models.auth.ResetPasswordResponse
import com.decagon.myrootapp.data.models.auth.VerificationCode
import com.decagon.myrootapp.data.models.auth.VerificationResponse
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserPayload
import com.decagon.myrootapp.data.models.user.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object NetworkRepository {

    val userApi = UserAPI()
    val authAPI = AuthAPI()
    val treeAPI = TreeAPI()
    val paymentAPI = PaymentAPI()
    val loginAPI = LoginAPI()

    val TAG = "NETWORK REPOSITORY"

    //User
    suspend fun createUser(userBody: UserBody): UserPayload{
        var status : UserPayload? = null
        withContext(Dispatchers.IO){
            try {
                status = userApi.addUserAsync(userBody).await().payload
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return status!!
    }

    //Login
    suspend fun loginUser(loginBody: LoginBody): LoginResponse{
        var response: LoginResponse? = null
        withContext(Dispatchers.IO){
            try {
                response = loginAPI.loginAsync(loginBody).await()
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }

    //Verification
    suspend fun verify(verificationCode: VerificationCode): VerificationResponse{
        var response: VerificationResponse? = null
        withContext(Dispatchers.IO){
            try {
                response = authAPI.verifyAsync(verificationCode).await()
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }

    suspend fun resetPassword(resetPasswordBody: ResetPasswordBody): ResetPasswordResponse{
        var response: ResetPasswordResponse? = null
        withContext(Dispatchers.IO){
            try {
                response = authAPI.resetPasswordAsync(resetPasswordBody).await()
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }

    //tree


    //payment

}