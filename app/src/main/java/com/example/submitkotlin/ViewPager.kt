package com.example.submitkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.text.FieldPosition


class ViewPager(list: ArrayList<Fragment>, fm: FragmentManager,lifecycle: Lifecycle)
    : FragmentStateAdapter(fm, lifecycle)
{
    val listArray:ArrayList<Fragment> = list

    override fun getItemCount(): Int{
        return listArray.size
    }

    override fun createFragment(position: Int): Fragment{
        return listArray[position]
    }
}