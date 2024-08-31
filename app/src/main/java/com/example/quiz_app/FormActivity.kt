package com.example.quiz_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.example.quiz_app.model.model_formula

class FormActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var toolbar: Toolbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)


        imageView= findViewById(R.id.imaform)
        val matem = intent.getParcelableExtra<model_formula>("matem")

        if (matem != null) {
            supportActionBar?.title = matem.name
            supportActionBar?.subtitle = matem.at
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

        if (matem != null) {
            imageView.setImageResource(matem.form)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}