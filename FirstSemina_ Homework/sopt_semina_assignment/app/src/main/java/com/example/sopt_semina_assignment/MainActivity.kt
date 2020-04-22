package com.example.sopt_semina_assignment

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

private val lastTimeBackPressed : Long = System.currentTimeMillis()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
