package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import com.decagon.myrootapp.R

/**
 * A simple [Fragment] subclass.
 */
class OccasionFragment : Fragment() {
    lateinit var occassionBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_occasion, container, false)

        occassionBtn = view.findViewById(R.id.buttonOccId)
        occassionBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_occasionFragment_to_howToFragment)
        }

        return view
    }

}
