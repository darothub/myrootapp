package com.decagon.myrootapp.ui.login

import android.graphics.Paint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.models.auth.ForgotPasswordResponse
import com.decagon.myrootapp.databinding.FragmentForgotPasswordBinding
import com.decagon.myrootapp.utils.NetworkState
import com.decagon.myrootapp.viewmodel.ForgotPasswordViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_forgot_password.*

/**
 * A simple [Fragment] subclass.
 */
class ForgotPasswordFragment : Fragment() {
    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    lateinit var viewModel: ForgotPasswordViewModel
    lateinit var binding: FragmentForgotPasswordBinding
    lateinit var response: ForgotPasswordResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
        val binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ForgotPasswordViewModel::class.java)

       binding.forgotEmailInput.addTextChangedListener(object : TextWatcher{
           override fun afterTextChanged(s: Editable?) {
               viewModel.email = s.toString() ?: ""
           }

           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
           }

           override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
           }

       })

        viewModel.isFormValid.observe(viewLifecycleOwner, Observer { valid ->
          binding.forgotSujbmitBtn.isEnabled = valid ?: false
        })

        binding.forgotSujbmitBtn.setOnClickListener {

            response = viewModel.submitEmail(viewModel.email)
                    viewModel.networkState.observe(viewLifecycleOwner, Observer {
                        if(it == NetworkState.ERROR){
                            Snackbar.make (requireView(),response.message, Snackbar.LENGTH_LONG).show()
                        }else {
                            binding.progress.visibility =
                                if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
                            findNavController().navigate(R.id.action_forgotPasswordFragment_to_newPasswordFragment)
                        }
            })

        }


        return binding.root

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
