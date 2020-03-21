package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.decagon.myrootapp.R
import com.decagon.myrootapp.databinding.FragmentTreeTypeBinding

/**
 * A simple [Fragment] subclass.
 */
class TreeTypeFragment : Fragment() {

    val args:TreeTypeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tree_type, container, false)
        val binding = FragmentTreeTypeBinding.inflate(inflater, container, false)

        var treeAddedProperties = args.tree

        binding.decorativeType!!.setOnClickListener {

            var treeTypeOne = binding.nameDecorativeId!!.text.toString()
            treeAddedProperties.treeType = treeTypeOne

            Log.d("TreeTypeFragment", "what's inside treeAddedProperties:$treeAddedProperties")

        }

        binding.fruitType!!.setOnClickListener {

            var treeTypeTwo = binding.nameFruitId!!.text.toString()
            treeAddedProperties.treeType = treeTypeTwo

            Log.d("TreeTypeFragment", "what's inside treeAddedProperties:$treeAddedProperties")

        }

        binding.environmentalType!!.setOnClickListener {

            var treeTypeThree = binding.nameEnvironmentalId!!.text.toString()
            treeAddedProperties.treeType = treeTypeThree

            Log.d("TreeTypeFragment", "what's inside treeAddedProperties:$treeAddedProperties")

        }

        binding.treeTypeButtonId!!.setOnClickListener {

            Log.d("TreeTypeFragment", "what's inside treeAddedPropertiesButton:$treeAddedProperties")

        }


        return binding.root


    }

}
