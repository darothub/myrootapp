package com.decagon.myrootapp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.decagon.myrootapp.data.api.*
import com.decagon.myrootapp.data.models.auth.*
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserPayload
import com.decagon.myrootapp.utils.BaseRepository
import com.decagon.myrootapp.utils.NetworkState
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkRepository(): BaseRepository() {

    val userApi = UserAPI()
    val authAPI = AuthAPI()
    val treeAPI = TreeAPI()
    val paymentAPI = PaymentAPI()
    val loginAPI = LoginAPI()

    val TAG = "NETWORK REPOSITORY"

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

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
    suspend fun verify(header: String, verificationCode: VerificationCode): VerificationResponse{
        var response: VerificationResponse? = null
        withContext(Dispatchers.IO){
            try {
                response =   authAPI.verifyAsync(header,verificationCode).await()
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }


    //forgotPassword

    suspend fun forgotPassword(email: ForgotPasswordBody):ForgotPasswordResponse{
        var response: ForgotPasswordResponse? = null

        withContext(Dispatchers.IO){
            try {

                response = authAPI.forgotPasswordAsync(email).await()
                if(response!!.status == 0){
                    _networkState.postValue(NetworkState.LOADED)
                }else{
                    _networkState.postValue(NetworkState.ERROR)
                }

            }catch (t:Throwable){
                _networkState.postValue(NetworkState.ERROR)
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }

    //resetPassword

    suspend fun resetPassword(resetPasswordBody: ResetPasswordBody): ResetPasswordResponse{
        var response: ResetPasswordResponse? = null
        withContext(Dispatchers.IO){
            try {
                response =  authAPI.resetPasswordAsync(resetPasswordBody).await()
            }catch (t: Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return response!!
    }

    //tree


    //payment

}