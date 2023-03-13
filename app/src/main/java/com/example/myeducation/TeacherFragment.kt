package com.example.myeducation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.navigation.fragment.findNavController
import com.example.myeducation.adapter.AdapterMentor
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentTeacherBinding
import com.example.myeducation.model.CourseWithMentor
import com.example.myeducation.model.Mentor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class TeacherFragment : Fragment() {
    lateinit var binding: FragmentTeacherBinding
    lateinit var adapter: AdapterMentor
    lateinit var database: AppDatabase
    lateinit var onItemSelectedListener:OnItemSelectedListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teacher, container, false)
        binding = FragmentTeacherBinding.bind(view)

        val courseWithMentor = arguments?.getSerializable("course") as CourseWithMentor
        onItemSelectedListener.onItemSelected(courseWithMentor)
        database = AppDatabase.getInstance(requireContext())


        database.courseDao().getAllMentors(courseWithMentor.course.id!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            adapter.submitList(it)
        }

        adapter= AdapterMentor(object :AdapterMentor.MyClick{
            override fun deletedMentor(mentor: Mentor, position: Int) {

            }

            override fun editMentor(mentor: Mentor, position: Int) {

            }

        })




        binding.rvMentor.adapter = adapter



        return view
    }
    interface OnItemSelectedListener{
        fun onItemSelected(course: CourseWithMentor)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemSelectedListener=context as OnItemSelectedListener
    }


}