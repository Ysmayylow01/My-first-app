package com.example.quiz_app

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView

class zehin_bolum : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zehin_bolum)

        val Informatika = findViewById<CardView>(R.id.cdInfor)
        val Matematika = findViewById<CardView>(R.id.cdmatem)
        val English = findViewById<CardView>(R.id.cdENG)
        val Fizika = findViewById<CardView>(R.id.cdFizik)
        val Taryh = findViewById<CardView>(R.id.cdTaryh)
        val Umumy = findViewById<CardView>(R.id.cdumumy)
        val imageView = findViewById<ImageView>(R.id.btnimg)






        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val objectAnimator = ObjectAnimator.ofFloat(
            imageView,
            "rotationX",
            0f,
            360f
        )
        objectAnimator.duration = 2500 // rotate duration in milliseconds
        objectAnimator.repeatCount = ObjectAnimator.INFINITE // repeat indefinitely

        objectAnimator.start()


        Informatika.setOnClickListener {
            val intent = Intent(this, zehin_info::class.java)
            startActivity(intent)
        }
        Matematika.setOnClickListener {
            val intent = Intent(this, zehin_matem::class.java)
            startActivity(intent)
        }
        English.setOnClickListener{
            val intent = Intent(this, zehin_english::class.java)
            startActivity(intent)
        }
        Fizika.setOnClickListener {
            val intent = Intent(this, zehin_fizika::class.java)
            startActivity(intent)
        }
        Taryh.setOnClickListener {
            val intent = Intent(this,zehin_taryh::class.java)
            startActivity(intent)
        }
        Umumy.setOnClickListener {
            val intent = Intent (this, zehin_umumy::class.java)
            startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}