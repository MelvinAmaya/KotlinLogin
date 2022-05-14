package com.example.kotlinlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BlankFragmentLog.Comunicador{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lista = listOf(
            "Login",
            "REGISTRARSE"
        )
        val icons = listOf(
            R.drawable.ic_baseline_login_24,
            R.drawable.ic_baseline_how_to_reg_24
        )
        pagina.adapter = MainAdapter(this, lista)

        TabLayoutMediator(tab_Layout1,pagina){tab,position ->
            tab.text=lista[position]
            tab.icon= ContextCompat.getDrawable(this,icons[position])

        }.attach()
    }

    override fun devolverDato(dato: String) {
        if(dato.equals("1"))
        {
            val intent = Intent(this,ListaContacto::class.java)
            startActivity(intent)
            finish()
        }
    }
}