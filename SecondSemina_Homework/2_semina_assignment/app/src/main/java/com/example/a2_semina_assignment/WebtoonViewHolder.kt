package com.example.a2_semina_assignment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class WebtoonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val img : ImageView = itemView.findViewById(R.id.img_contents)
    val title : TextView = itemView.findViewById(R.id.tv_title)
    val star : TextView = itemView.findViewById(R.id.tv_star)
    val subtitle : TextView = itemView.findViewById(R.id.tv_subtitle)

    fun bind(webtoonData : WebtoonData)
    {
        title.text = webtoonData.title
        star.text = webtoonData.star
        subtitle.text = webtoonData.subtitle
        Glide.with(itemView).load(webtoonData.img).into(img)

    }
}