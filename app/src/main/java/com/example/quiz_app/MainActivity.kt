package com.example.quiz_app



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import java.util.*


class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long=0
    private var backToast : Toast? = null

    lateinit var kitap : CardView
    lateinit var Zehinli : CardView

    lateinit var Sazlama : CardView
    lateinit var Barada : CardView
    lateinit var Formula : CardView
    lateinit var tvTM : TextView
    lateinit var tvEN : TextView

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         kitap = findViewById(R.id.cdkitap)
         Zehinli = findViewById(R.id.cdzehin)
         Sazlama = findViewById(R.id.cdsozluk)
         Barada = findViewById(R.id.cdinfo)
       Formula = findViewById(R.id.cdformul)
        tvEN= findViewById(R.id.tvEN)
        tvTM=findViewById(R.id.tvTM)


        val viewflipper = findViewById<ViewFlipper>(R.id.viewflipper)

        val line = findViewById<LinearLayout>(R.id.linear)

        line.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in))


        viewflipper.isAutoStart = true
        viewflipper.flipInterval = 2000
        viewflipper.setInAnimation(applicationContext, android.R.anim.slide_in_left)
        viewflipper.setOutAnimation(applicationContext, android.R.anim.slide_out_right)


        kitap.setOnClickListener {
            val intent = Intent(this, bolumKitap::class.java)
            startActivity(intent)
        }

        Zehinli.setOnClickListener {
            val intent = Intent(this, zehin_bolum::class.java)
            startActivity(intent)
        }

        Barada.setOnClickListener {
            val intent = Intent(this, baradaActivity::class.java)
            startActivity(intent)
        }

        Formula.setOnClickListener {
            val intent = Intent(this, formula_main::class.java)
            startActivity(intent)
        }
        Sazlama.setOnClickListener {
            val intent = Intent(this, sozluk::class.java)
            startActivity(intent)
        }
        tvTM.setOnClickListener{
            setLocaleWithAnimation("en")

        }
        tvEN.setOnClickListener{
            setLocaleWithAnimation("bg")
        }



    }
        override fun onBackPressed() {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)

            builder.setTitle(R.string.attention)
            builder.setMessage(R.string.çykjakmy)
            builder.setPositiveButton(R.string.hawa, { dialog, id ->
                super@MainActivity.onBackPressed()
            })
            builder.setNegativeButton(R.string.yok,
               { dialog, id ->  })
            builder.show()
        }


    @SuppressLint("ResourceAsColor")
    private fun setLocaleWithAnimation(localeCode: String) {
        val locale = Locale(localeCode)

        Locale.setDefault(locale)
        val config = resources.configuration
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
        if (localeCode == "en") {
            tvTM.setTextColor(R.color.red)
        } else {
             tvEN.setTextColor(R.color.red)
        }
        val intent = intent
        val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.fade_in, R.anim.fadein)
        ActivityCompat.startActivity(this, intent, options.toBundle())
        finish()
    }
}