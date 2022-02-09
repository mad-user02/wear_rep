package com.example.worldcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatAdapter (var items : List<FilmsModel>) :  RecyclerView.Adapter<ChatAdapter.Holder>(){
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val rand : TextView = itemView.findViewById(R.id.rand)
        fun bind(item : FilmsModel) {
            name.text = item.name
            rand.text = item.movieId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return(Holder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}