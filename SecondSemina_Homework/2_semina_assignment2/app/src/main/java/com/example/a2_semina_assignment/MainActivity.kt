package com.example.a2_semina_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init()
    {
        main_view_pager.adapter = MainPagerAdapter(supportFragmentManager)
        main_view_pager.offscreenPageLimit = 2
        main_view_pager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener
        {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                main_bottom_navigation.menu.getItem(position).isChecked=true
            }

        })


        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.menu_home->main_view_pager.currentItem =0
                R.id.menu_book->main_view_pager.currentItem =1
                R.id.menu_person->main_view_pager.currentItem =2
            }
            true
        }

    }
}
