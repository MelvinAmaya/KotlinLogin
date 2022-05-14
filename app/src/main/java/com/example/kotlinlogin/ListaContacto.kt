package com.example.kotlinlogin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaContacto : AppCompatActivity() {
    //creamos variable nulas
    private var recyclerView: RecyclerView?=null
    private var recyclerViewAdapter:AddContacto?=null
    //creamos una lista la cual le enviar datos a la clase Movie_amigos
    private var movieList = mutableListOf<Movie_contacto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contacto)
        //declaramos la lista como un arrayList
        movieList = ArrayList()
        //enlazamos los elementos graficos para utilizarlos en la programacion
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        //el adapter sera igual a la clase Addfiends la cual recibe como paramero la lista
        recyclerViewAdapter = AddContacto(movieList)
        //creamos una varable
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        //igualamos la variable recyclerView a layoutManager
        recyclerView!!.layoutManager = layoutManager
        //creamos el metoso ClickListener para cuando precionen un rejistro se muestre el titulo del mismo
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<Movie_contacto> {
            override fun onItemClick(data: Movie_contacto) {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:" + data.numero)
                startActivity(dialIntent)
            }
        })
        //enviamos el adapter al recyclerView
        recyclerView!!.adapter = recyclerViewAdapter
        //llamamos el metodo
        prepareMovie()
    }

    //creamos el metodo
    private fun prepareMovie() {
        //creamos la variable movie la cual alamcenara los registros
        var movie = Movie_contacto("Joel Cristopher Turcios Turcios", R.drawable.cris,78964608)
        //agregamos el registro a la lista
        movieList.add(movie)
        movie = Movie_contacto("Melvin Adiel Vasquez Mejia", R.drawable.adiel, 97654730)
        movieList.add(movie)
        movie = Movie_contacto("Luis Antonio Guevara Andrade", R.drawable.luis,67427498)
        movieList.add(movie)
        movie = Movie_contacto("Ivan Alexander Chavez Treminio", R.drawable.ivan,72347598)
        movieList.add(movie)
        movie = Movie_contacto("Luis Manuel Ayala Flores", R.drawable.luisu,70984631)
        movieList.add(movie)
        movie = Movie_contacto("Salvador Mauricio Chavarria", R.drawable.camba,66438901)
        movieList.add(movie)
        movie = Movie_contacto("Gabriel Eduardo Henriquez Gonzalez", R.drawable.gabriel,77459800)
        movieList.add(movie)
        movie = Movie_contacto("Jaime Arnoldo Rodriguez Meza", R.drawable.jaime,79909944)
        movieList.add(movie)
        movie = Movie_contacto("Melvin josue perez garcia", R.drawable.perez,76567789)
        movieList.add(movie)
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}