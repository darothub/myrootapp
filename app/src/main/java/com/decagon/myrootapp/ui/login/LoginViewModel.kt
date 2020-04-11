package com.decagon.myrootapp.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.decagon.myrootapp.data.network.NetworkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Main)
    private val repository = NetworkRepository()

    fun login(loginBody: LoginBody): LoginResponse{
        var response: LoginResponse? = null
        scope.launch {
            try {
                response = repository.loginUser(loginBody)
            }catch (t: Throwable){
                Log.e("LOGIN VIEW MODEL", t.message.toString())
            }
        }
        return response!!
    }
}
