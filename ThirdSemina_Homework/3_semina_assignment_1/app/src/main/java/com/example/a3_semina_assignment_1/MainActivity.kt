package com.example.a3_semina_assignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3_semina_assignment.RecyclerViewAdapter
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var bookAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init()
    {


        edit_book.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                loadDatas(s.toString())
            }

        })

    }
    fun loadDatas(s: String)
    {

        val token = "KakaoAK 017f3524cd4174d42c4c58e25b386856"
        val requestToServer=RequestToServer
        requestToServer.service.requestBook(token,s)
            .enqueue(
                object : retrofit2.Callback<responseBookData> {
                    override fun onFailure(call: Call<responseBookData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<responseBookData>,
                        response: Response<responseBookData>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("data", "${response.body()}")

                                    bookAdapter  = RecyclerViewAdapter(applicationContext, response!!.body()!!.documents)
                                    bookAdapter.notifyDataSetChanged()
                                    rv_book.addItemDecoration(VerticalItemDecorator(2))
                                    rv_book.adapter = bookAdapter
                        }

                    }
                }
            )


    }

}
