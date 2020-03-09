package com.decagon.myrootapp.ui.login

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import kotlinx.android.synthetic.main.fragment_forgot_password.*

/**
 * A simple [Fragment] subclass.
 */
class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forgot_no_account.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        forgot_no_account.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signUpFragment)
        }

        forgot_back_btn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}
