package com.example.a3_semina_assignment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a3_semina_assignment_1.DocumentsData
import com.example.a3_semina_assignment_1.R

class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val img = itemView.findViewById<ImageView>(R.id.img_book_item)
    val tv_title = itemView.findViewById<TextView>(R.id.tv_title_item)
    val tv_subtitle = itemView.findViewById<TextView>(R.id.tv_subtitle_item)
    val tv_author = itemView.findViewById<TextView>(R.id.tv_author_item)
    val tv_price = itemView.findViewById<TextView>(R.id.tv_price_item)
    fun bind(Data: DocumentsData)
    {
        tv_title.text = Data.title
        tv_subtitle.text = Data.contents
        tv_author.text = "저자 : "+Data.authors[0]
        tv_price.text = "정가 : "+Data.price.toString()+"원"
        Glide.with(itemView).load(Data.thumbnail).into(img)
    }
}