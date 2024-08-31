package com.example.quiz_app

import android.content.DialogInterface
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class zehin_info : AppCompatActivity() {


    lateinit var soragList:ArrayList<SoragModel>
    private  var index: Int = 0
    lateinit var soragModel : SoragModel

    private var dogryJogapCount:Int=0
    private var yalnysJogapCount:Int=0
    private   var total:Int=10

    lateinit var gosmak :TextView
    lateinit var sorag : TextView
    lateinit var jogap_A : Button
    lateinit var jogap_B : Button
    lateinit var jogap_C : Button
    lateinit var jogap_D : Button
    lateinit var dowam:Button



    private var backPressedTime: Long=0
    private var backToast : Toast? = null

    lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zehin_info)
        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.informatika)


        gosmak=findViewById(R.id.gosmak)
        sorag=findViewById(R.id.sorag)
        jogap_A=findViewById(R.id.jogap_A)
        jogap_B=findViewById(R.id.jogap_B)
        jogap_C=findViewById(R.id.jogap_C)
        jogap_D=findViewById(R.id.jogap_D)
        dowam=findViewById(R.id.Dowam)


        soragList= ArrayList()
        soragList.add(SoragModel("Ilkinji el telefonyny kim oýlap tapdy?",
            "Grayam Bell", "Stiw Jobs", "Eynsteyn", "Bill Gates","Grayam Bell"))
        soragList.add(SoragModel("Aplle kompaniýany döreden?",
            "Stiw Jobs", "Elon Musk", "Mark Zukerburg", "Bill Gates","Stiw Jobs"))
        soragList.add(SoragModel("Kompýuteriň atasy kim?",
            "Grayam Bell", "Elon Musk", "Bill Gates", "Charlie Babbage","Charlie Babbage"))
        soragList.add(SoragModel("Kompýuter syçanjygy näçinji ýylda döredildi?",
            "1972", "1960", "1964", "1965","1964"))
        soragList.add(SoragModel("Häzirki zaman kompýuterine meňzeş ilkinji şahsy noutbuk näçinji ýylda döredildi?",
            "1977", "1982", "1994", "1985","1982"))
        soragList.add(SoragModel("Samsung kompaniýasyny kim döretdi?",
            "Grayam Bell", "Stiw Jobs", "Lee Byung-Chull", "Bill Gates","Lee Byung-Chull"))
        soragList.add(SoragModel("HP kompaniýasynyň doly ady näme?",
            "Hewet-Pakard", "History-Packard", "Hewlett-Part", "Hewlett-Packard","Hewlett-Packard"))
        soragList.add(SoragModel("Lenova kompaniýasynyň döredilen ýyly?",
            "1984", "1969", "1998", "1987","1984"))
        soragList.add(SoragModel("Faceboogi kim döretdi?", "Stiw Jobs",
            "Elon Musk", "Bill Gates", "Mark Zukerburg","Mark Zukerburg"))
        soragList.add(SoragModel("HP kompaniýasy naçinji ýylda döredildi?",
            "1939", "1945", "1994", "1955","1939"))
        soragList.add(SoragModel("IP doly ady näme?",
            "Internet Port", "Internet Protocol", "Internet part", "Hiç birem däl","Internet Protocol"))



        soragList.shuffle()
        soragModel = soragList[index]

        setAllQuestions()
        onFinish()



    }


    fun dowam_clicked(view: View) {
        disableButton()
        onFinish()

    }




    private fun onFinish() {
        index ++
        if (index<=total){
            soragModel=soragList[index]
            gosmak.text=index.toString()
            resetBackground()
            enableButton()
            setAllQuestions()

        }

        else {
            oyunNetije()
        }

    }





    private fun dogryJogap(option: Button){
        option.background=getDrawable(R.drawable.correct_option_border_bg)
        dogryJogapCount++
        var  mediaPlayer = MediaPlayer.create(applicationContext,R.raw.dogryy)
        mediaPlayer.start()

    }



    private fun yalnysJogap(option: Button){
        option.background=getDrawable(R.drawable.wrong_option_border_bg)
        yalnysJogapCount++

        var  mediaPlayer = MediaPlayer.create(applicationContext,R.raw.yalnys)
        mediaPlayer.start()

    }

    private fun oyunNetije(){

        var pastStatus = ""
        pastStatus = if (dogryJogapCount==total){
            getString(R.string.berekella)
        }
        else if (dogryJogapCount > total * 0.50) {
            getString(R.string.gowy)
        } else {
            getString(R.string.pes)
        }
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
            .setTitle(pastStatus)
            .setMessage(getString(R.string.netije) + " $dogryJogapCount " + getString(R.string.netije2) + " $yalnysJogapCount " + getString(R.string.netije3))
            .setPositiveButton( getString(R.string.restart),
                { dialogInterFace: DialogInterface?, i: Int -> tazedenBasla() })
        builder.setNegativeButton( getString(R.string.goybolsun),
            { dialogInterFace: DialogInterface?, i: Int ->
                backToast?.cancel()
                finish()
            })
            .show()

    }

    private fun tazedenBasla() {
        dogryJogapCount = 0
        index = 0
        yalnysJogapCount = 0

        soragList.shuffle()
        soragModel = soragList[index]

        setAllQuestions()
        onFinish()
        return
    }


    private fun setAllQuestions() {
        sorag.text=soragModel.sorag
        jogap_A.text=soragModel.jogap_A
        jogap_B.text=soragModel.jogap_B
        jogap_C.text=soragModel.jogap_C
        jogap_D.text=soragModel.jogap_D
    }

    private fun enableButton() {
        jogap_A.isClickable=true
        jogap_B.isClickable=true
        jogap_C.isClickable=true
        jogap_D.isClickable=true
        dowam.isClickable=false




    }

    private fun disableButton(){
        jogap_A.isClickable=false
        jogap_B.isClickable=false
        jogap_C.isClickable=false
        jogap_D.isClickable=false
        dowam.isClickable=true



    }

    private fun resetBackground(){
        jogap_A.background=resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_B.background=resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_C.background=resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_D.background=resources.getDrawable(R.drawable.selected_option_border_bg)
    }

    fun jogap_Aclicked(view: View){
        disableButton()

        if(soragModel.jogap_A==soragModel.jogap){
            jogap_A.background=resources.getDrawable(R.drawable.correct_option_border_bg)

            dogryJogap(jogap_A)
        }
        else  {
            yalnysJogap(jogap_A)
        }


    }

    fun jogap_Bclicked(view: View){
        disableButton()
        if(soragModel.jogap_B==soragModel.jogap){
            jogap_B.background=resources.getDrawable(R.drawable.correct_option_border_bg)

            dogryJogap(jogap_B)
        }
        else {
            yalnysJogap(jogap_B)
        }

    }

    fun jogap_Cclicked(view: View){
        disableButton()
        if(soragModel.jogap_C==soragModel.jogap){
            jogap_C.background=resources.getDrawable(R.drawable.correct_option_border_bg)

            dogryJogap(jogap_C)
        }
        else {
            yalnysJogap(jogap_C)
        }

    }

    fun jogap_Dclicked(view: View){
        disableButton()
        if(soragModel.jogap_D==soragModel.jogap){
            jogap_D.background=resources.getDrawable(R.drawable.correct_option_border_bg)

            dogryJogap(jogap_D)
        }
        else {
            yalnysJogap(jogap_D)
        }

    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}