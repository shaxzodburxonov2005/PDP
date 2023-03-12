package com.example.myeducation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myeducation.R
import com.example.myeducation.databinding.ItemAddcourseBinding
import com.example.myeducation.model.CourseWithMentor

class AdapterCourse (val clickRoot:MyClick): ListAdapter<CourseWithMentor,
        AdapterCourse.MyViewHolder>(MyDiffUtil()) {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(course: CourseWithMentor, position: Int) {
            val bind = ItemAddcourseBinding.bind(itemView)
            bind.courseName.text = course.course.courseName

            bind.root.setOnClickListener {
                clickRoot.rootClick(course,position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_addcourse, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    class MyDiffUtil : DiffUtil.ItemCallback<CourseWithMentor>() {
        override fun areItemsTheSame(oldItem: CourseWithMentor, newItem: CourseWithMentor): Boolean {
            return oldItem.course.id == newItem.course.id
        }

        override fun areContentsTheSame(oldItem: CourseWithMentor, newItem: CourseWithMentor): Boolean {
            return oldItem == newItem
        }

    }

    interface MyClick {
        fun rootClick(course: CourseWithMentor,position: Int)
    }

}




