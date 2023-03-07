package com.example.myeducation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myeducation.adapter.FragmentAdapter
import com.example.myeducation.databinding.FragmentTabBinding
import com.google.android.material.tabs.TabLayoutMediator


class TabFragment : Fragment() {
    lateinit var binding:FragmentTabBinding
    lateinit var list: ArrayList<Fragment>
    lateinit var adapter: FragmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_tab, container, false)
        binding= FragmentTabBinding.bind(view)
        loadFragment()
        adapter= FragmentAdapter(list,requireActivity())
        binding.viewPager.adapter=adapter
        val titleList= arrayListOf("Ochilgan guruhlar","Ochilayotgan guruhlar")
        TabLayoutMediator(binding.tabView,binding.viewPager
        ){tab,position->
            tab.text=titleList[position]
        }.attach()

        return view
    }

    private fun loadFragment() {
       list=ArrayList()
        list.add(OpenedGroupsFragment())
        list.add(OpeningGroupsFragment())
    }


}