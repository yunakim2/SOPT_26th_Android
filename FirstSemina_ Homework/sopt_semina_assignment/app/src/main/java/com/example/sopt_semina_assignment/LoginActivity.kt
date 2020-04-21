package com.example.sopt_semina_assignment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }
    fun init()
    {
        edit_id.setText(intent.getStringExtra("id")?.toString())
        edit_pw.setText(intent.getStringExtra("pw")?.toString())

        btn_login.setOnClickListener {
            if(edit_id.text.isNullOrBlank() || edit_pw.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else
            {
                autoLogin()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

        }
        tv_register_btn.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    fun autoLogin()
    {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val CODE = 100
        //

    }

}
