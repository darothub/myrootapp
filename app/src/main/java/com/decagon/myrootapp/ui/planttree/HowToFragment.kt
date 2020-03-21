package com.decagon.myrootapp.ui.planttree

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.decagon.myrootapp.R
import com.decagon.myrootapp.databinding.FragmentHowToBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HowToFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HowToFragment : Fragment() {


    val args:HowToFragmentArgs by navArgs()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_how_to, container, false)

        val binding = FragmentHowToBinding.inflate(inflater, container, false)

        var treeProperties = args.tree

        binding.remoteMethod.setOnClickListener {

            var locationType = binding.remoteId.text.toString()
            treeProperties.locationType = locationType

            Log.d("LOCATION_TYPE_TWO", "check arg content: $treeProperties")
        }

        binding.inPersonMethod.setOnClickListener {

            var locationTypeTwo = binding.inPersonId.text.toString()
            treeProperties.locationType = locationTypeTwo
            Log.d("LOCATION_TYPE_THREE", "check arg content: $treeProperties")

        }

        binding.buttonHowId.setOnClickListener {

            val action =HowToFragmentDirections.actionHowToFragmentToTreeTypeFragment(treeProperties)
            findNavController().navigate(action)
            Log.d("LOCATION_TYPE", "check arg content: $treeProperties")
        }



        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HowToFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HowToFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
