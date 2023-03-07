package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.databinding.FragmentAllCaourseBinding


class AllCaourseFragment : Fragment() {
    lateinit var binding:FragmentAllCaourseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_all_caourse, container, false)
        binding= FragmentAllCaourseBinding.bind(view)
        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.tabFragment)
        }

        return view
    }

}