package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.navigation.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.databinding.FragmentOccasionBinding

/**
 * A simple [Fragment] subclass.
 */
class OccasionFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_occasion, container, false)

        val binding = FragmentOccasionBinding.inflate(inflater, container, false)






        return binding.root
    }

}
