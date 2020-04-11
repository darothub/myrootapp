package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.decagon.myrootapp.R
import com.decagon.myrootapp.data.models.tree.Reason
import com.decagon.myrootapp.data.models.tree.Tree
import com.decagon.myrootapp.databinding.FragmentReasonBinding
import kotlinx.android.synthetic.main.fragment_reason.*

/**
 * A simple [Fragment] subclass.
 */
class ReasonFragment : Fragment() {

//    val args:ReasonFragmentArgs by navArgs()
    var plantTree:Tree? = null

    var reason:Reason? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_reason, container, false)

        val binding = FragmentReasonBinding.inflate(inflater, container, false)

        binding.nextReasonBtn.setOnClickListener {

//            val newTree = onCheckedBoxClicked(it)
            val newTree = onCheckedBoxClicked(gift_check, climate_check, job_check)
            Log.i("NewTree", "$newTree")
            val action = ReasonFragmentDirections.actionReasonFragmentToOccasionFragment()
            action.tree = newTree

            findNavController().navigate(action)
            Log.d("INSIDE_ARGUMENT", "$action")
//            findNavController().navigate(R.id.action_reasonFragment_to_occasionFragment)
//            Log.d("VIEW_CHANGE_TREEOBJECT", "here now:${newTree}")

        }






        return binding.root
    }

    fun onCheckedBoxClicked(vararg checkBox: CheckBox): Tree{
        var tree = Tree()
        var reason = Reason()

        for(checks in checkBox){
            if(checks.isChecked){
                val name = resources.getResourceEntryName(checks.id)
                when(name){
                    "gift_check" ->{
                        Log.i("checkbutton", "yes $name")
                        reason.isGift = true
                        true
                    }
                    "climate_check" ->{
                        Log.i("checkbutton", "yes $name")
                        reason.isClimate = true
                        true
                    }
                    "job_check" ->{
                        Log.i("checkbutton", "yes $name")
                        reason.isJob = true
                        true
                    }
                }

            }

        }

        tree.reason = reason
        return tree

    }

}
