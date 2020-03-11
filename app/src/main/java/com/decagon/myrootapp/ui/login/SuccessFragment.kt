package com.decagon.myrootapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.decagon.myrootapp.R
import kotlinx.android.synthetic.main.fragment_success.*

/**
 * A simple [Fragment] subclass.
 */
class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        success_gotit_btn.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_loginFragment)
        }
    }

}
