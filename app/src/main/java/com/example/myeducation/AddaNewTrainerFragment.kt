package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.FragmentAddaNewTrainerBinding
import com.example.myeducation.model.Mentor


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


        binding.AddSave.setOnClickListener {
            val firstname=binding.nameAdd.text.toString()
            val fatherName=binding.fatherNameAdd.text.toString()
            val lastName=binding.firstnameAdd.text.toString()




        }


        return view
    }

}