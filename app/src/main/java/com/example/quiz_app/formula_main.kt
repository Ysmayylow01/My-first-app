package com.example.quiz_app

import android.app.PendingIntent.getActivity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_app.fragments.FizikaFragment
import com.example.quiz_app.fragments.HimiyaFragment
import com.example.quiz_app.fragments.MatematikaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class formula_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula_main)

       supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val actionBar: ActionBar?
        actionBar = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#F8F8F8"))

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable)
        }


        val bottom_navigation=findViewById<BottomNavigationView>(R.id.bottom_nav)
        makeMatematikaFragment()


        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home -> {
                    makeMatematikaFragment()
                }
                R.id.navigation_dashboard-> {
                    makeFizikaFragment()
                }
                R.id.navigation_notifications-> {
                    makeHimiyaFragment()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }

    private fun  makeMatematikaFragment(){
        setTitle(R.string.matem)

        val matematikaFragment = MatematikaFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flWrapper, matematikaFragment, "MatematikaFragment")
        fragmentTransaction.commit()
    }

    private fun  makeFizikaFragment(){
        setTitle(R.string.fizika)
        val fizikaFragment = FizikaFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flWrapper, fizikaFragment, "FizikaFragment")
        fragmentTransaction.commit()
    }

    private fun  makeHimiyaFragment(){
        setTitle(R.string.himiya)
        val himiyaFragment = HimiyaFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flWrapper, himiyaFragment, "HimiyaFragment")
        fragmentTransaction.commit()
    }
}