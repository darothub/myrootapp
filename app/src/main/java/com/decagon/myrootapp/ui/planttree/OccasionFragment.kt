package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.models.tree.Tree
import com.decagon.myrootapp.databinding.FragmentOccasionBinding
import kotlinx.android.synthetic.main.fragment_occasion.*

/**
 * A simple [Fragment] subclass.
 */
class OccasionFragment : Fragment(){

    var isClicked:Boolean? = false

    val args:OccasionFragmentArgs by navArgs()

//    var treeCollection = args.tree

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_occasion, container, false)

        val binding = FragmentOccasionBinding.inflate(inflater, container, false)

        var treeCollection = args.tree

        binding.yourBirthdays.setOnClickListener{
            var input = binding.birthdayOcassion.text.toString()
//            args.tree?.occassion = input
            treeCollection?.occassion = input
            Log.d("CHECKING", "is it available:${args.tree!!.occassion}")
        }
        binding.yourAnniversary.setOnClickListener{
            var input2 = binding.anniversarOcassion.text.toString()
//            args.tree?.occassion = input2
            treeCollection?.occassion = input2
            Log.d("ANNIVERSARY", "yes my anniversary: ${args.tree?.occassion}")
        }
        binding.yourHoliday.setOnClickListener{
            var input3 = binding.holidayOccassion.text.toString()
//            args.tree?.occassion = input3
            treeCollection?.occassion = input3
            Log.d("HOLIDAY", "yes my holiday: ${args.tree?.occassion}")
        }
        binding.yourOthers.setOnClickListener{
            var input4 = binding.othersOcassion.text.toString()
//            args.tree?.occassion = input4
            treeCollection?.occassion = input4
            Log.d("OTHERS", "yes my others: ${args.tree?.occassion}")
        }

        binding.buttonOccId.setOnClickListener {

            val action = OccasionFragmentDirections.actionOccasionFragmentToHowToFragment(treeCollection!!)
            findNavController().navigate(action)

//            findNavController().navigate(R.id.action_occasionFragment_to_howToFragment)

            Log.d("EFFECT", "what is inside: $treeCollection")
        }



        return binding.root
    }






}
