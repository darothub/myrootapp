package com.decagon.myrootapp.ui.signup

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.Preferences
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserPayload
import com.decagon.myrootapp.data.models.user.UserResponse
import com.decagon.myrootapp.utils.Result
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.signup_email_input
import kotlinx.android.synthetic.main.fragment_sign_up.signup_phone_input


class SignUpFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    private lateinit var userBody: UserBody


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        signup_submit_btn.setOnClickListener {


            val response = sendUser()


            response.observe(viewLifecycleOwner, Observer{
                Log.d("SIGNUPFRAGMENTRESPONSE", "inside response:${it}")
                when(it){
                    is Result.Success -> {
                        saveUserInfo(it.data)
                        findNavController().navigate(R.id.action_signUpFragment_to_verificationFragment)
                    }
                    is Result.Error -> {
                        Toast.makeText(
                            this.context,
                            "${it.exception.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })


        }

        signup_have_an_account.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        signup_have_an_account.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        signup_back_btn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun sendUser(): LiveData<Result<UserResponse>> {
        var userBody = UserBody()
        //verification
        when {
            signup_email_input.editText!!.text.isEmpty() -> {
                signup_email_input.editText!!.error = "Email cannot be empty"
            }
            signup_phone_input.editText!!.text.isEmpty() -> {
                signup_phone_input.editText!!.error = "Phone cannot be empty"
            }
            signup_country_input.editText!!.text.isEmpty() -> {
                signup_country_input.editText!!.error = "Country cannot be empty"
            }
            signup_password_input.editText!!.text.isEmpty() -> {
                signup_password_input.editText!!.error = "Password cannot be empty"
            }
            signup_password_input.editText!!.text.length < 6 -> {
                signup_password_input.editText!!.error = "Password cannot be less than 6 characters"
            }
            signup_name_input.editText!!.text.isEmpty() -> {
                signup_name_input.editText!!.error = "Name cannot be empty"
            }
            else -> {
                val email = signup_email_input.editText!!.text.toString()
                val country = signup_country_input.editText!!.text.toString()
                val name = signup_name_input.editText!!.text.toString()
                val password = signup_password_input.editText!!.text.toString()
                val phone = signup_phone_input.editText!!.text.toString()
                userBody = UserBody(country, email, false, name, password, phone)
            }
        }


//        Log.d("USER REG", userBody.toString())

//         viewModel.createUser(userBody!!)
        return viewModel.createUser(userBody)
    }

    private fun saveUserInfo(userResponse: UserResponse) {

        this.activity?.let { Preferences.setEmail(it, userResponse.payload?.email!!) }
        this.activity?.let { Preferences.saveAuthToken(it, userResponse.token!!) }
    }
}
