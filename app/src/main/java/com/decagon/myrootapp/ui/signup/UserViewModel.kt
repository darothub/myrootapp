package com.decagon.myrootapp.ui.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.decagon.myrootapp.data.models.auth.ResetPasswordBody
import com.decagon.myrootapp.data.models.auth.ResetPasswordResponse
import com.decagon.myrootapp.data.models.auth.VerificationCode
import com.decagon.myrootapp.data.models.auth.VerificationResponse
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserPayload
import com.decagon.myrootapp.data.models.user.UserResponse
import com.decagon.myrootapp.data.network.NetworkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    private val repository = NetworkRepository()
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Main)


    fun createUser(userBody: UserBody): UserResponse {
        var userPayload: UserResponse? = null
        scope.launch {
            userPayload = repository.createUser(userBody)
            Log.d("UserViewModel", "this is the response:${userPayload}")
        }
        return userPayload!!
    }

    fun verifyCode(header: String, verificationCode: VerificationCode): VerificationResponse{
        var verificationResponse: VerificationResponse? = null
        scope.launch {
            verificationResponse = repository.verify(header, verificationCode)
        }
        return verificationResponse!!
    }

    fun login(loginBody: LoginBody): LoginResponse{
        var response: LoginResponse? = null
        scope.launch {
            response = repository.loginUser(loginBody)
        }
        return response!!
    }

    fun resetPassword(resetPasswordBody: ResetPasswordBody): ResetPasswordResponse{
        var response: ResetPasswordResponse? = null
        scope.launch {
            response = repository.resetPassword(resetPasswordBody)
        }
        return response!!
    }

}