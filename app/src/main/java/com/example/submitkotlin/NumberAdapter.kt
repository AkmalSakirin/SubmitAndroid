package com.example.submitkotlin

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val listName: List<Int>
)
    : RecyclerView.Adapter<NumberAdapter.ViewHolder>(){
    //Tempat untuk menaruh layout yang digunakan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }
    //untuk mengambil data dari constructor
    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        holder.text.text = listName[position].toString()
    }

    //jumlah item yang akan dimunculkan
    override fun getItemCount(): Int {
        return listName.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val text = view.findViewById<TextView>(R.id.textView)
    }
}