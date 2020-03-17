package com.decagon.myrootapp.ui.login

import android.graphics.Paint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.Preferences
import com.decagon.myrootapp.data.models.login.LoginBody
import com.decagon.myrootapp.data.models.login.LoginResponse
import com.decagon.myrootapp.utils.InputUtils
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_dont_have_account.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        login_dont_have_account.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        login_forgot_pass_text.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        login_forgot_pass_text.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        login_back_btn.setOnClickListener {
            findNavController().popBackStack()
        }

        login_btn.setOnClickListener {
            val response = login()
            when {
                response == null -> {
                    Toast.makeText(context, "Please solve all errors to continue", Toast.LENGTH_SHORT)
                        .show()
                }
                response.status == 200 -> {
                    saveInfo(response)
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardActivity)
                }
                else -> {
                    Toast.makeText(context, "${response.status}, ${response.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        login_password_input.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length < 6) {
                    login_password_input.editText!!.error = "Password must 6 characters or more"
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


    }

    private fun login(): LoginResponse? {
        var loginResponse: LoginResponse? = null
        when {
            login_email_input.editText!!.text.toString().isEmpty() -> {
                login_email_input.editText!!.error = "Email cannot be empty"
            }
            InputUtils.validateEmail(login_email_input.editText!!.text.toString()) -> {
                login_email_input.editText!!.error = "Email not valid"
            }
            login_password_input.editText!!.text.toString().isEmpty() -> {
                login_password_input.editText!!.error = " Password cannot be empty"
            }
            else -> {
                val email = login_email_input.editText!!.text.toString()
                val password = login_password_input.editText!!.text.toString()
                val loginBody = LoginBody(email, password)
                loginResponse = viewModel.login(loginBody)
            }
        }
        return loginResponse
    }

    private fun saveInfo(loginResponse: LoginResponse){
        activity?.let { Preferences.saveAuthToken(it, loginResponse.token) }
        activity?.let { Preferences.setEmail(it, loginResponse.payload.email) }
        activity?.let { Preferences.saveID(it, loginResponse.payload.id) }
        activity?.let { Preferences.savePhone(it, loginResponse.payload.phone) }
        activity?.let { Preferences.saveName(it, loginResponse.payload.name) }
    }
}
