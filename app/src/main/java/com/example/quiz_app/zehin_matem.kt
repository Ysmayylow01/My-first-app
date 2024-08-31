package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class zehin_matem : AppCompatActivity() {


    lateinit var soragList:ArrayList<SoragModel>
    private  var index: Int = 0
    lateinit var soragModel : SoragModel

    private var dogryJogapCount:Int=0
    private var yalnysJogapCount:Int=0
    private   var total:Int=10
    lateinit var dowam:Button

lateinit var gosmak:TextView
    lateinit var sorag : TextView
    lateinit var jogap_A : Button
    lateinit var jogap_B : Button
    lateinit var jogap_C : Button
    lateinit var jogap_D : Button



    private var backPressedTime: Long=0
    private var backToast : Toast? = null


    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zehin_matem)

        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.matem)


        gosmak=findViewById(R.id.gosmak)
        sorag=findViewById(R.id.sorag)
        jogap_A=findViewById(R.id.jogap_A)
        jogap_B=findViewById(R.id.jogap_B)
        jogap_C=findViewById(R.id.jogap_C)
        jogap_D=findViewById(R.id.jogap_D)
        dowam=findViewById(R.id.Dowam)

        soragList= ArrayList()
        soragList.add(SoragModel("A,B,C hersi bir san bolmak bilen, C<B<A sertini kanagatlandyryan nace uc basgancakly ABC sany bardyr?",
            "116","120","124","127","120"))
        soragList.add(SoragModel("A,B,C hersi bir san, AB bolsa iki basgancakly san we AB-(A+B+C)=47 bolanyna gora A nace?",
            "6","5","4","3","6"))
        soragList.add(SoragModel("Kerimiň ýaşy Azadyň ýaşynyň iki essesidir. 3 ýyl ozal, ikisiniň ýaşlarynyň jemi 42 bolsa Azat şu wagt näçe ýaşynda?",
            "16","8","20","4","16"))
        soragList.add(SoragModel("Batyr, hepde-de 10 litr suw icmekdedir.Batyr 1 yylda (52 hepde) jemi nace litr suw icer?",
            "530","660","480","520","520"))
        soragList.add(SoragModel("2.5 rasional san asakdakylardan haysysyna dendir?",
            "0.4","0.2","0.6,","0.8","0.4"))
        soragList.add(SoragModel("12 yyl sonra 77 yasayan Atam 20 yyl on nace yasyndady?",
            "35","55","45","25","45"))
        soragList.add(SoragModel("(110*5)+(4*80) mysalyn netijesi nacedir?",
            "870","670","107","770","870"))
        soragList.add(SoragModel("5x+8=2x-1 denlemanin koki nacedir?",
            "-1","-3","1","3","-3"))
        soragList.add(SoragModel("2,3,4,5,7,10,15,19,20,23ynace sanyny dineje ozune we 1-e bolunyar?",
            "5","4","3","6","6"))
        soragList.add(SoragModel("0.6 onlyk sany asakdakylardan haysysyna dendir?",
            "2/5","3/5","2/3","4.5","3/5"))
        soragList.add(SoragModel("3x/4+1/4=12 Aşakdakylaryň haýsysy deňlemäniň çözgüdi?",
            "12","16","14","18","12"))





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