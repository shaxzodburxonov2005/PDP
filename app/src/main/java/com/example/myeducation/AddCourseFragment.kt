package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.adapter.AdapterCourse
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentAddCourseBinding
import com.example.myeducation.model.Course
import com.example.myeducation.model.CourseWithMentor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AddCourseFragment : Fragment() {
    lateinit var binding: FragmentAddCourseBinding
    lateinit var adapterCourse: AdapterCourse
    lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_course, container, false)
        binding = FragmentAddCourseBinding.bind(view)
        database = AppDatabase.getInstance(requireContext())
        database.courseDao().getCourseWithMentor()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                adapterCourse.submitList(it)
            }

        adapterCourse = AdapterCourse(object : AdapterCourse.MyClick {
            override fun rootClick(course: CourseWithMentor, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("course", course)
                findNavController().navigate(R.id.aboutFragment, bundle)
            }

        })




        binding.rv.adapter = adapterCourse




        return view
    }


}