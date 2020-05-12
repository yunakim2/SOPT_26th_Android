package com.example.sopt_semina_assignment.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt_semina_assignment.R
import com.example.sopt_semina_assignment.data.ResponseRegister
import com.example.sopt_semina_assignment.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val CODE =100
    lateinit var pref : SharedPreferences
    lateinit var editor :SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }
    fun init()
    {
        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()
        btn_register.setOnClickListener {
            if(edit_pw_register.text.isNullOrBlank() || edit_id_register.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                if(edit_pw_register.text.toString().equals(edit_pwcheck_register.text.toString()))
                {
                    network()
                }
                else
                {
                    Toast.makeText(this, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
    fun network()
    {
        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()
        val requestToServer= RequestToServer
        val id = edit_id_register.text.toString()
        val pw = edit_pw_register.text.toString()
        val name = edit_name_register.text.toString()
        val phone = edit_phone_register.text.toString()
        val email = edit_email_register.text.toString()

        if(name.isNullOrBlank() || phone.isNullOrBlank() || email.isNullOrBlank())
        {
            Toast.makeText(applicationContext, "모두 다 입력해주세요!!", Toast.LENGTH_SHORT).show()
        }
        else {
            requestToServer.service.requestRegister(id, pw, name, email, phone)
                .enqueue(
                    object : Callback<ResponseRegister> {
                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                            Log.d("통신실패", "${t}")
                        }

                        override fun onResponse(
                            call: Call<ResponseRegister>,
                            response: Response<ResponseRegister>
                        ) {

                            if (response.isSuccessful) {

                                if (response.body()!!.success) {
                                    Log.d("회원가입 성공", "id : ${id}, pw : ${pw}")
                                    Toast.makeText(
                                        applicationContext,
                                        "회원가입이 완료되었습니다.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent =
                                        Intent(applicationContext, LoginActivity::class.java)
                                    editor.putString("id", edit_id_register.text.toString())
                                    editor.putString("pw", edit_pw_register.text.toString())
                                    editor.commit()
                                    intent.putExtra("id", edit_id_register.text.toString())
                                    intent.putExtra("pw", edit_pw_register.text.toString())
                                    startActivityForResult(intent, CODE)
                                }
                                else
                                {
                                    if (response.body()!!.status == 200) {
                                        Toast.makeText(
                                            applicationContext,
                                            "${response.body()!!.message}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        }
                    }
                )
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
