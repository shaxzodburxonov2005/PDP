package com.example.myeducation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myeducation.R
import com.example.myeducation.databinding.ItemAddcourseBinding
import com.example.myeducation.model.Course

class AdapterCourse(
    var list: List<Course>,

    ): RecyclerView.Adapter<AdapterCourse.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(course: Course, position: Int) {
            val bind = ItemAddcourseBinding.bind(itemView)
            bind.courseName.text=course.courseName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_addcourse, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }
    interface ClickListener {
        fun rootClick(course: Course,position: Int)
    }
}