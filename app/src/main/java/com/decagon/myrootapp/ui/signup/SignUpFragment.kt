package com.decagon.myrootapp.ui.signup

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
}
