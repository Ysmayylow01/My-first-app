package com.example.quiz_app


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.widget.Toolbar
import com.github.barteksc.pdfviewer.PDFView

class pdfActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)



        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)

        val pdfView : PDFView = findViewById(R.id.btnpdf)
        val kitap = intent.getParcelableExtra<KITAP>("kitap")


        if (kitap != null) {
            supportActionBar?.title = kitap.name
            supportActionBar?.subtitle = kitap.awtor
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

        if (kitap != null) {
            pdfView.fromAsset(kitap.pdf)
                .autoSpacing(true)
                .pageFling(true)
                .load()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}