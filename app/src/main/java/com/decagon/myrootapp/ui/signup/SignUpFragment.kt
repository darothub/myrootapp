package com.decagon.myrootapp.ui.signup

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.models.user.UserBody
import com.decagon.myrootapp.data.models.user.UserResponse
import kotlinx.android.synthetic.main.fragment_sign_up.*


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
            findNavController().navigate(R.id.action_signUpFragment_to_verificationFragment)
        }

        signup_have_an_account.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        signup_have_an_account.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        signup_back_btn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun sendUser(): UserResponse{
        val email = signup_email_input.editText!!.text.toString()
        val country = signup_country_input.editText!!.text.toString()
        val name = signup_name_input.editText!!.text.toString()
        val password = signup_password_input.editText!!.text.toString()
        val phone = signup_phone_input.editText!!.text.toString()
        val userBody = UserBody(country, email, false, name, password, phone)

        Log.d("USER REG", userBody.toString())

        return viewModel.createUser(userBody)
    }
}
