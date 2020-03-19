package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.navigation.findNavController

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.models.tree.Reason
import com.decagon.myrootapp.databinding.FragmentReasonBinding

/**
 * A simple [Fragment] subclass.
 */
class ReasonFragment : Fragment() {

    var reason:Reason? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_reason, container, false)
        val binding = FragmentReasonBinding.inflate(inflater, container, false)

        binding.nextReasonBtn.setOnClickListener {

            onCheckedBoxClicked(it)

        }






        return binding.root
    }

    fun onCheckedBoxClicked(view:View){
        if(view is CheckBox){
            val checked:Boolean = view.isChecked

            when(view.id){
                R.id.climate_check -> {
                    if(checked){
                        reason?.isClimate = true
                    } else {
                        reason?.isClimate = false
                    }
                }

                R.id.job_check -> {
                    if(checked){
                        reason?.isJob = true
                    } else {
                        reason?.isJob = true
                    }
                }

                R.id.gift_check -> {
                    if(checked){
                        reason?.isGift = true
                    } else {
                        reason?.isGift = false
                    }
                }

            }


        }
    }

}
