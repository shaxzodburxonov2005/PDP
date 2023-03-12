package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myeducation.adapter.AdapterCourse
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentAllCaourseBinding
import com.example.myeducation.model.CourseWithMentor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class AllCaourseFragment : Fragment() {
    lateinit var binding:FragmentAllCaourseBinding
    lateinit var adapter:AdapterCourse
    lateinit var database: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_all_caourse, container, false)
        binding= FragmentAllCaourseBinding.bind(view)
        database = AppDatabase.getInstance(requireContext())

        database.courseDao().getCourseWithMentor()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { course ->
                adapter.submitList(course)
            }

        adapter = AdapterCourse(object : AdapterCourse.MyClick {
            override fun rootClick(course: CourseWithMentor, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("course", course)
                findNavController().navigate(R.id.tabFragment, bundle)
            }

        })

        binding.rvGroup.adapter = adapter




        return view
    }

}