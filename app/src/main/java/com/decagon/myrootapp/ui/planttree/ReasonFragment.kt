package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.databinding.FragmentReasonBinding

/**
 * A simple [Fragment] subclass.
 */
class ReasonFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_reason, container, false)
        val binding = FragmentReasonBinding.inflate(inflater, container, false)




        return binding.root
    }

}
