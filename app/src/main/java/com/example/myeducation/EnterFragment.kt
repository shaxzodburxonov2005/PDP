package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.databinding.FragmentEnterBinding


class EnterFragment : Fragment() {
    lateinit var binding:FragmentEnterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_enter, container, false)
        binding= FragmentEnterBinding.bind(view)
        binding.cons1.setOnClickListener {
            findNavController().navigate(R.id.addCourseFragment)
        }

        return view
    }

    }
