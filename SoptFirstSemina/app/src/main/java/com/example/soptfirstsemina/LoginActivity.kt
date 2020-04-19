package com.example.soptfirstsemina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txt_register

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



      login_btn_login.setOnClickListener {
          if(login_edit_id.text.isNotBlank() && login_edit_pw.text.isNotBlank())
          {
              val intent = Intent(applicationContext, MainActivity::class.java)
              startActivity(intent)
          }
          else
          {
              Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
          }
      }

        login_txt_register.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
