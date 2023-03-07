package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myeducation.databinding.FragmentTeacherBinding
import com.example.myeducation.model.Course


class TeacherFragment : Fragment() {
    lateinit var binding:FragmentTeacherBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_teacher, container, false)
        binding= FragmentTeacherBinding.bind(view)
        val bind=arguments?.getSerializable("course") as Course
        binding

        return view
    }

  
}