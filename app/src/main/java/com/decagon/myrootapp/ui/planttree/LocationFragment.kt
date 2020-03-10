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
class LocationFragment : Fragment() {
    lateinit var move3Button:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        move3Button = view.findViewById(R.id.move2Id)
        move3Button.setOnClickListener {
            view.findNavController().navigate(R.id.action_locationFragment_to_reasonFragment)
        }



        return view
    }

}
