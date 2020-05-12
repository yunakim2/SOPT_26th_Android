package com.example.sopt_semina_assignment.ui.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.sopt_semina_assignment.R
import com.example.sopt_semina_assignment.ui.LoginActivity
import com.example.sopt_semina_assignment.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_mypage.*

/**
 * A simple [Fragment] subclass.
 */
class MypageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pref : SharedPreferences = this.activity!!.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        if(!pref.getString("id",null).toString().isNullOrBlank())
        {
            val id = pref.getString("id",null).toString()
            val pw = pref.getString("pw",null).toString()
            tv_id_mypage.text = id
            tv_pw_mypage.text = pw

        }
        btn_logout_mypage.setOnClickListener {
            editor.clear()
            editor.commit()
            val intent = Intent(context, LoginActivity::class.java)
            activity!!.finish()
            startActivity(intent)
        }
    }

}
