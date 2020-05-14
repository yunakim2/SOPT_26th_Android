package com.example.a3_semina_assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_semina_assignment_1.DocumentsData
import com.example.a3_semina_assignment_1.R

class RecyclerViewAdapter(private val context: Context,var datas : List<DocumentsData>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}