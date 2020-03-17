package com.decagon.myrootapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decagon.myrootapp.data.models.auth.ForgotPasswordBody
import com.decagon.myrootapp.data.models.auth.ForgotPasswordResponse
import com.decagon.myrootapp.data.network.NetworkRepository
import com.decagon.myrootapp.utils.NetworkState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class ForgotPasswordViewModel: ViewModel() {

    private val repository = NetworkRepository()


    private val _isFormValid = MutableLiveData<Boolean>()

    private val viewModelJob = Job()



    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val emailPattern = ("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").toRegex()

    private val _message = MutableLiveData<String>()



    val isFormValid: LiveData<Boolean>
        get() = _isFormValid

    val message : LiveData<String>
         get() = _message

    var email = ""

        set(value) {
            field = value
            validateForm()
        }

    private fun validateForm() {
        if (email.trim().matches(emailPattern)) {
            _isFormValid.postValue(true)
        } else {
            _isFormValid.postValue(false)
        }
    }

    val networkState: LiveData<NetworkState> by lazy {
        repository.networkState
    }

    fun submitEmail(email: String): ForgotPasswordResponse {
        val emailText = ForgotPasswordBody("")
        var response: ForgotPasswordResponse? = null
        viewModelScope.launch {
            try{
                emailText.email = email
                response = repository.forgotPassword(emailText)
            }
            catch (e: Exception){
                Log.e("Forgot", e.message.toString())
            }
        }
        return response!!
    }







}