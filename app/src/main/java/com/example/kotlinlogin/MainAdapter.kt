package com.example.kotlinlogin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainAdapter (fragment: FragmentActivity, private val itesm:List<String> ):
    FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return itesm.size
    }

    override fun createFragment(position: Int): Fragment {
        val FragmentUno = BlankFragmentLog()
        val fragmentDos = BlankFragmentReg()

        return when(position){
            0->{
                FragmentUno
            }
            1->{
                fragmentDos
            }
            else-> FragmentUno
        }

    }
}