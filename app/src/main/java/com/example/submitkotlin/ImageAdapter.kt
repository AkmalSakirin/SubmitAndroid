package com.example.submitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val listImage: List<Int>
)
    : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    //Tempat untuk menaruh layout yang digunakan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_image, parent, false)
        )
    }
    //untuk mengambil data dari constructor
    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.image.setImageResource( listImage[position])
    }

    //jumlah item yang akan dimunculkan
    override fun getItemCount(): Int {
        return listImage.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
    }
}