package com.example.quiz_app

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class splash_screen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView = findViewById<ImageView>(R.id.splashLogo)

        Glide.with(this).load(R.drawable.loading).into(imageView)
        Handler().postDelayed( {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide__in, R.anim.slide__out)
            finish()
        }, SPLASH_TIME)
    }
}