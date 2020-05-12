package com.example.sopt_semina_assignment.ui

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.sopt_semina_assignment.R
import kotlinx.android.synthetic.main.activity_main.*

private val lastTimeBackPressed : Long = System.currentTimeMillis()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        if(!pref.getString("id",null).toString().isNullOrBlank())
        {
            val id = pref.getString("id",null).toString()
            val pw = pref.getString("pw",null).toString()
           Toast.makeText(this, "id : ${id} pw: ${pw}", Toast.LENGTH_SHORT).show();
            init()
        }

        setResult(Activity.RESULT_OK,intent)

    }
    fun init()
    {
        main_view_pager.adapter = MainPagerAdapter(supportFragmentManager)
        main_view_pager.offscreenPageLimit = 2
        main_view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener
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


    override fun onBackPressed() {
        if(System.currentTimeMillis()- lastTimeBackPressed <1500)
        {
            finish()
            return
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.",Toast.LENGTH_SHORT).show()
        super.onBackPressed()



    }
}
