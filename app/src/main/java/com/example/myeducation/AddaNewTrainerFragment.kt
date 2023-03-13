package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentAddaNewTrainerBinding
import com.example.myeducation.model.Course
import com.example.myeducation.model.CourseWithMentor
import com.example.myeducation.model.Mentor
import io.reactivex.rxjava3.core.Completable


class AddaNewTrainerFragment : Fragment() {
    lateinit var binding:FragmentAddaNewTrainerBinding
    lateinit var database: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_adda_new_trainer, container, false)
        binding= FragmentAddaNewTrainerBinding.bind(view)
        database= AppDatabase.getInstance(requireContext())



        val course=arguments?.getSerializable("course") as Course

        binding.AddSave.setOnClickListener {
            val firstname=binding.nameAdd.text.toString()
            val fatherName=binding.fatherNameAdd.text.toString()
            val lastName=binding.firstnameAdd.text.toString()


            val mentor = Mentor(null,firstname,lastName,fatherName,course.id!!)

            Completable.fromCallable {
                database.courseDao().insertMentor(mentor)
            }.subscribe()
            binding.fatherNameAdd.text.clear()
            binding.nameAdd.text.clear()
            binding.firstnameAdd.text.clear()

        }


        return view
    }

}