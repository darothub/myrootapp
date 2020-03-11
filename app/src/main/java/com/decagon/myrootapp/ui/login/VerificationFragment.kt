package com.decagon.myrootapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import kotlinx.android.synthetic.main.fragment_verification.*

/**
 * A simple [Fragment] subclass.
 */
class VerificationFragment : Fragment() {

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
            findNavController().popBackStack()
        }

        verification_submit_btn.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_successFragment)
        }
    }

}
