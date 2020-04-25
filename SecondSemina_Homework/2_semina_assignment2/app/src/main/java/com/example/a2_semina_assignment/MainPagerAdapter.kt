package com.example.a2_semina_assignment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int =3

    override fun getItem(position: Int): Fragment {
        return when(position)
        {
            0->HomeFragment()
            1->LibraryFragment()
            else->MypageFragment()
        }
    }
}