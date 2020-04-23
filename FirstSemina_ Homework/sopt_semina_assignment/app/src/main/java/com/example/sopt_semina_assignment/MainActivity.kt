package com.example.sopt_semina_assignment

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private val lastTimeBackPressed : Long = System.currentTimeMillis()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        if(!pref.getString("id",null).toString().isNullOrBlank())
        {
            tv_id_main.text = "아이디 : "+pref.getString("id",null).toString()
            tv_pw_main.text = "비밀번호 : "+pref.getString("pw",null).toString()
        }

        setResult(Activity.RESULT_OK,intent)

    }

    override fun onBackPressed() {
        if(System.currentTimeMillis()- lastTimeBackPressed<1500)
        {
            finish()
            return
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.",Toast.LENGTH_SHORT).show()
        super.onBackPressed()



    }
}
