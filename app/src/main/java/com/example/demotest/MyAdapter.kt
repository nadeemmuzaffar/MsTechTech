package com.example.retrofit_yt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demotest.R
import com.example.demotest.model.newmodel.ItemResponseItem

class MyAdapter(var con : Context , var list : List<Images>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v)
    {
        var img = v.findViewById<ImageView>(R.id.imge_logo)
        var tvName = v.findViewById<TextView>(R.id.tv_item)
        var  tvDescription=v.findViewById<TextView>(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.single_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(con).load(list[position].imgurl).into(holder.img)

        holder.tvName.text = list[position].name
        holder.tvDescription.text = list[position].tag

    }

    override fun getItemCount(): Int {
        return list.count()
    }

}