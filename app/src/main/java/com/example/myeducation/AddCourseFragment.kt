package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myeducation.adapter.AdapterCourse
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentAddCourseBinding

class AddCourseFragment : Fragment() {
    lateinit var binding:FragmentAddCourseBinding
     lateinit var adapterCourse: AdapterCourse
     lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_course, container, false)
        binding= FragmentAddCourseBinding.bind(view)
        database= AppDatabase.getInstance(requireContext())
        val list=database.courseDao().getAllCourse()

        adapterCourse=AdapterCourse(list)


        binding.rv.adapter=adapterCourse




        return view
    }


}