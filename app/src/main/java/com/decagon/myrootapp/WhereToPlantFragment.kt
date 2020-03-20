package com.decagon.myrootapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.myrootapp.databinding.FragmentWhereToPlantBinding
import com.decagon.myrootapp.ui.planttree.HowToFragmentArgs

/**
 * A simple [Fragment] subclass.
 */
class WhereToPlantFragment : Fragment() {

//    val args:WhereToPlantFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_where_to_plant, container, false)

        val binding = FragmentWhereToPlantBinding.inflate(inflater, container, false)

        binding.whereToPlantBtn.setOnClickListener {

//            val action = WhereToPlantFragmentDirections.actionWhereToPlantFragmentToReasonFragment(args.tree)
//            findNavController().navigate(action)

            findNavController().navigate(R.id.action_whereToPlantFragment_to_reasonFragment)

        }

        return binding.root

    }

}
