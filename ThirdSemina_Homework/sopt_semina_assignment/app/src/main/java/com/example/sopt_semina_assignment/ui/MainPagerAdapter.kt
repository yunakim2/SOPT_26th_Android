package com.example.sopt_semina_assignment.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sopt_semina_assignment.ui.fragment.HomeFragment
import com.example.sopt_semina_assignment.ui.fragment.LibraryFragment
import com.example.sopt_semina_assignment.ui.fragment.MypageFragment

class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int =3

    override fun getItem(position: Int): Fragment {
        return when(position)
        {
            0-> HomeFragment()
            1-> LibraryFragment()
            else-> MypageFragment()
        }
    }
}