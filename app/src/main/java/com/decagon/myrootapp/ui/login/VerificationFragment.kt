package com.decagon.myrootapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.Preferences
import com.decagon.myrootapp.data.models.auth.VerificationCode
import com.decagon.myrootapp.data.models.auth.VerificationResponse
import com.decagon.myrootapp.ui.signup.UserViewModel
import com.decagon.myrootapp.utils.Result
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_verification.*

/**
 * A simple [Fragment] subclass.
 */
class VerificationFragment : Fragment() {

    private lateinit var viewModel:UserViewModel
     lateinit var mVerificationCode:VerificationCode

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        verification_back_btn.setOnClickListener {

//            val response = sendVerificationCode()
//            response.observe(viewLifecycleOwner, Observer{
//
//            })

            findNavController().popBackStack()
        }

        verification_submit_btn.setOnClickListener {

            val response = sendVerificationCode()

            response.observe(viewLifecycleOwner, Observer{

                when(it){
                    is Result.Success -> {
                        findNavController().navigate(R.id.action_verificationFragment_to_successFragment)
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
    }

    // capture te verification code sent to the user
    private fun sendVerificationCode(): LiveData<Result<VerificationResponse>> {
        var token = provideTokenStoredInPreference()
        var mVerificationCode = VerificationCode()
        when {
            digit_one.editableText.toString().isEmpty() -> {
                Toast.makeText(context, "Please enter the four-digit code", Toast.LENGTH_SHORT).show()
            }
            digit_two.editableText.toString().isEmpty() -> {
                Toast.makeText(context, "Please enter the four-digit code", Toast.LENGTH_SHORT).show()
            }
            digit_three.editableText.toString().isEmpty() -> {
                Toast.makeText(context, "Please enter the four-digit code", Toast.LENGTH_SHORT).show()
            }
            digit_four.editableText.toString().isEmpty() -> {
                Toast.makeText(context, "Please enter the four-digit code", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val code1 = digit_one.editableText.toString()
                val code2 = digit_two.editableText.toString()
                val code3 = digit_three.editableText.toString()
                val code4 = digit_four.editableText.toString()
                mVerificationCode = VerificationCode(code1+code2+code3+code4)
            }
        }


        return viewModel.verifyCode(token , mVerificationCode)
    }

    private fun provideTokenStoredInPreference():String{

        val savedToken =  Preferences.getAuthToken(requireActivity().parent)
        return savedToken

    }

}
