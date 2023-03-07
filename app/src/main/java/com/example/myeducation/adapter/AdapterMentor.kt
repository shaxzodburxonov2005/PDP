package com.example.myeducation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myeducation.R
import com.example.myeducation.databinding.ItemMentorsBinding
import com.example.myeducation.model.Mentor

class AdapterMentor
    (val clickRoot: AdapterMentor.MyClick): ListAdapter<Mentor,
        AdapterMentor.MyViewHolder>(MyDiffUtil()) {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind( mentor: Mentor,position: Int) {
            val bind = ItemMentorsBinding.bind(itemView)
            bind.fatherTvName.text=mentor.fathersName
            bind.tvNameMentors.text="${mentor.mentorName} ${mentor.sName}"

            bind.deleted.setOnClickListener {
                clickRoot.deletedMentor(mentor,position)
            }
            bind.editText.setOnClickListener {
                clickRoot.editMentor(mentor,position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_mentors, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Mentor>() {
        override fun areItemsTheSame(oldItem: Mentor, newItem: Mentor): Boolean {
            return oldItem.mentorId == newItem.mentorId
        }

        override fun areContentsTheSame(oldItem: Mentor, newItem: Mentor): Boolean {
            return oldItem==newItem
        }
    }

    interface MyClick {
        fun deletedMentor(mentor: Mentor,position: Int)
        fun editMentor(mentor: Mentor,position: Int)
    }

}