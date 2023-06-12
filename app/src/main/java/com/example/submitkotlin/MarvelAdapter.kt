package com.example.submitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarvelAdapter(
    private val listMarvel: List<MarvelModel>,
    private val listener : OnAdapterListener,
    )
    : RecyclerView.Adapter<MarvelAdapter.ViewHolder>(){
    //Tempat untuk menaruh layout yang digunakan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_model, parent, false)
        )
    }
    //untuk mengambil data dari constructor
    override fun onBindViewHolder(holder: MarvelAdapter.ViewHolder, position: Int) {
        val marvel = listMarvel[position]
        holder.imageView.setImageResource( marvel.image)
        holder.textView.text = marvel.name
        holder.itemView.setOnClickListener{
            listener.onClick(marvel)
        }
    }

    //jumlah item yang akan dimunculkan
    override fun getItemCount(): Int {
        return listMarvel.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
    }
    interface OnAdapterListener{
        fun onClick(movie: MarvelModel)
    }
}