package com.example.kotlinlogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AddContacto constructor(private val movieList: List<Movie_contacto>) :
    RecyclerView.Adapter<AddContacto.MyViewHolder>() {
    private var clickListener: ClickListener<Movie_contacto>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.plantilla, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.title.text = movie.Nombre
        holder.image.setBackgroundResource(movie.image)
        holder.cardView.setOnClickListener {
            clickListener!!.onItemClick(movie)
        }
        holder.rating.text = "Numero : ${movie.numero}"
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setOnItemClickListener(movieClickListener: ClickListener<Movie_contacto>?) {
        clickListener = movieClickListener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val rating: TextView = itemView.findViewById(R.id.textRating)

    }
}

interface ClickListener<T> {
    fun onItemClick(data: T)
}