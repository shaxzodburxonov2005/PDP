package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.adapter.AdapterCourse
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentMentorsBinding
import com.example.myeducation.model.Course
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MentorsFragment : Fragment() {
    lateinit var binding:FragmentMentorsBinding
    lateinit var adapter:AdapterCourse
    lateinit var database: AppDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mentors, container, false)
        binding= FragmentMentorsBinding.bind(view)
        database= AppDatabase.getInstance(requireContext())

        database.courseDao().getAllCourse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{course->
             adapter.submitList(course)
            }
        adapter= AdapterCourse(object :AdapterCourse.MyClick{
            override fun rootClick(course: Course, position: Int) {
                val bundle=Bundle()
                bundle.putSerializable("course",course)
                findNavController().navigate(R.id.teacherFragment,bundle)
            }

        })

        binding.rvAdapter.adapter=adapter

        return view
    }

}