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
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val CODE =100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }
    fun init()
    {
        var pref :SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        var editor : SharedPreferences.Editor = pref.edit()
        btn_register.setOnClickListener {
            if(edit_pw_register.text.isNullOrBlank() || edit_email_register.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                if(edit_pw_register.text.toString().equals(edit_pwcheck_register.text.toString()))
                {
                    Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    editor.putString("id",edit_email_register.text.toString())
                    editor.putString("pw",edit_pw_register.text.toString())
                    editor.commit()
                    intent.putExtra("id",edit_email_register.text.toString())
                    intent.putExtra("pw",edit_pw_register.text.toString())
                    startActivityForResult(intent,CODE)
                }
                else
                {
                    Toast.makeText(this, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK)
        {
            if(requestCode==CODE)
            {
                finish()
            }
        }

    }



}
