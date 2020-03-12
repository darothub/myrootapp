package com.decagon.myrootapp.ui.signup

import androidx.lifecycle.ViewModel
import com.decagon.myrootapp.data.models.auth.VerificationCode
import com.decagon.myrootapp.data.models.auth.VerificationResponse
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserPayload
import com.decagon.myrootapp.data.models.user.UserResponse
import com.decagon.myrootapp.data.network.NetworkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    private val repository = NetworkRepository
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Main)


    fun createUser(userBody: UserBody): UserResponse {
        var userPayload: UserResponse? = null
        scope.launch {
            userPayload = repository.createUser(userBody)
        }
        return userPayload!!
    }

    fun verifyCode(verificationCode: VerificationCode): VerificationResponse{
        var verificationResponse: VerificationResponse? = null
        scope.launch {
            verificationResponse = repository.verify(verificationCode)
        }
        return verificationResponse!!
    }

}