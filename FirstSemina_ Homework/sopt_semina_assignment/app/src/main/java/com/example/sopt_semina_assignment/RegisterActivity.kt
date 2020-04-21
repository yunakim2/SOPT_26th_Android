package com.example.sopt_semina_assignment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }
    fun init()
    {
        btn_register.setOnClickListener {
            if(edit_pw_register.text.isNullOrBlank() || edit_email_register.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                if(edit_pw_register.text.toString().equals(edit_pwcheck_register.text.toString()))
                {
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    intent.putExtra("id",edit_email_register.text.toString())
                    intent.putExtra("pw",edit_pw_register.text.toString())
                    startActivityForResult(intent,100)
                }
                else
                {
                    Toast.makeText(this, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }


}
