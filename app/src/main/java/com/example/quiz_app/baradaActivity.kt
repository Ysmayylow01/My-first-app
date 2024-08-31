package com.example.quiz_app

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.graphics.rotationMatrix

class baradaActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barada)


        val viewflipper = findViewById<ViewFlipper>(R.id.viewflipper)
        val etutText = findViewById<TextView>(R.id.etut)
        val BarImage = findViewById<ImageView>(R.id.barOguz)
        val BarLogo = findViewById<ImageView>(R.id.Barlogo)
        val shareText = findViewById<TextView>(R.id.shareT)


        viewflipper.isAutoStart = true
        viewflipper.flipInterval = 2500
        viewflipper.setInAnimation(applicationContext,android.R.anim.slide_in_left)
        viewflipper.setOutAnimation(applicationContext,android.R.anim.slide_out_right)

        val objectAnimator = ObjectAnimator.ofFloat(
            BarImage,
            "rotationY",
            0f,
            360f
        )
        objectAnimator.duration = 2000 // rotate duration in milliseconds
        objectAnimator.repeatCount = ObjectAnimator.INFINITE // repeat indefinitely

        objectAnimator.start()

        val objectAnimator2 = ObjectAnimator.ofFloat(
            BarLogo,
            "rotationY",
            0f,
            360f
        )
        objectAnimator2.duration = 2000 // rotate duration in milliseconds
        objectAnimator2.repeatCount = ObjectAnimator.INFINITE // repeat indefinitely

        objectAnimator2.start()

        etutText.setOnClickListener{
            var intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data= Uri.parse("https://www.etut.edu.tm")
            startActivity(intent)
        }
shareText.setOnClickListener {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Hasabynyzda yeterlik pul yok.")
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
}


    }
}