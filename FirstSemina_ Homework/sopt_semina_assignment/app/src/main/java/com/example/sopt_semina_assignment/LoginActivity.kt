package com.example.sopt_semina_assignment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    val CODE=1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }
    fun init()
    {   var pref : SharedPreferences = getSharedPreferences("pref",Context.MODE_PRIVATE)
        var editor : SharedPreferences.Editor = pref.edit()


        edit_id.setText(intent.getStringExtra("id")?.toString())
        edit_pw.setText(intent.getStringExtra("pw")?.toString())
        setResult(Activity.RESULT_OK,intent)

        autoLogin()


        btn_login.setOnClickListener {
            if(edit_id.text.isNullOrBlank() || edit_pw.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else
            {
                editor.putString("id",edit_id.toString())
                editor.putString("pw",edit_pw.toString())
                editor.commit()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivityForResult(intent,CODE)
            }

        }
        tv_register_btn.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun autoLogin()
    {
        var pref : SharedPreferences = getSharedPreferences("pref",Context.MODE_PRIVATE)
        var editor : SharedPreferences.Editor = pref.edit()
        if(!(pref.getString("id",null).isNullOrBlank() || pref.getString("pw",null).isNullOrBlank()))
        {
            val id = pref.getString("id",null).toString()
            if(!id.isNullOrBlank())
            {
                Log.d("자동로그인 id ", "${id}")
                Toast.makeText(this, "${id}님 자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivityForResult(intent,CODE)
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CODE) {
                Log.d("로그인", "종료")
                finish()
            }
        }
    }

}

