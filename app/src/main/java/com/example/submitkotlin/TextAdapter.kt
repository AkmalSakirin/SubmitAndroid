package com.example.submitkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(
    private val listName: List<String>,
    private val listener: OnAdapterListener,
)
    : RecyclerView.Adapter<TextAdapter.ViewHolder>(){
    //Tempat untuk menaruh layout yang digunakan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }
    //untuk mengambil data dari constructor
    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        val name = listName[position]
        holder.textView.text = name
        holder.container.setOnClickListener{
            Log.e("TextAdapter", name)
            listener.onClick( name )
        }
    }

    //jumlah item yang akan dimunculkan
    override fun getItemCount(): Int {
        return listName.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val container = view.findViewById<ConstraintLayout>(R.id.container)
        val textView = view.findViewById<TextView>(R.id.textView)
    }
    interface OnAdapterListener {
        fun onClick(name: String)
    }
}