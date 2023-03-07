package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.databinding.FragmentAboutBinding
import com.example.myeducation.model.Course


class AboutFragment : Fragment() {
    lateinit var binding:FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_about, container, false)
        binding= FragmentAboutBinding.bind(view)
        val bind=arguments?.getSerializable("course")as Course
        binding.tvDescription.text=bind.courseDescription

        binding.addStudent.setOnClickListener {
            findNavController().navigate(R.id.addStudentFragment)
        }

        return view
    }


}