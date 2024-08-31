package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.ArrayList

class zehin_taryh : AppCompatActivity() {


    lateinit var soragList: ArrayList<SoragModel>
    private  var index: Int = 0
    lateinit var soragModel : SoragModel

    private var dogryJogapCount:Int=0
    private var yalnysJogapCount:Int=0
    private   var total:Int=10

    lateinit var gosmak : TextView
    lateinit var sorag : TextView
    lateinit var jogap_A : Button
    lateinit var jogap_B : Button
    lateinit var jogap_C : Button
    lateinit var jogap_D : Button
     lateinit var dowam:Button

    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    private var backPressedTime: Long=0
    private var backToast : Toast? = null




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zehin_taryh)


        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.taryh)

        gosmak=findViewById(R.id.gosmak)
        sorag=findViewById(R.id.sorag)
        jogap_A=findViewById(R.id.jogap_A)
        jogap_B=findViewById(R.id.jogap_B)
        jogap_C=findViewById(R.id.jogap_C)
        jogap_D=findViewById(R.id.jogap_D)
        dowam=findViewById(R.id.Dowam)

        soragList= ArrayList()
        soragList.add(SoragModel("Türkmenistanyň çäginde ýaşan iň gadymy adamlaryň ýaşan ýerleri Merkezi Aziýanyň haýsy gowagyndan tapyldy?",
            "Ellora", "Deşikdaş", "Ýeke", "Gyzyl","Deşikdaş"))
        soragList.add(SoragModel("Türkmenistanyň çäginde ýaşan iň gadymy adamlar näme diýip atlandyrypdyrlar?",
            "Irki", "Başarjaň", "Türkmenler", "Oguzlar","Başarjaň"))
        soragList.add(SoragModel("XX asyryň başlarynda dünýä döwletleri gurluşy boýunça haýsy dolandyryşly döwletlere bölünýärdi?",
            "imperatorlyk we kommunist", "Konstitusiýa we imperatorlyk", "Prezident we Demokratiýa", "respublika we monarhiýa","respublika we monarhiýa"))
        soragList.add(SoragModel("Monarhiýa gurluşly döwletleriň başynda kim durýardy?",
            "hökümdar(monarh)", "halk", "metropaliýa", "hiçkim","hökümdar(monarh)"))
        soragList.add(SoragModel("Kärdeşler arkalaşyklary ilkinji gezek dünýäniň haýsy ýurdunda döräpdir?",
            "Türkmenistan", "Britaniýa", "Amerika", "Russiýa","Britaniýa"))
        soragList.add(SoragModel("Afrika näçinji ýylda Ýewropa döwletleri tarapyndan paýlaşylyp gutardy?",
            "1934", "1956", "1900", "1924","1900"))
        soragList.add(SoragModel("Döwlet dolandyryşyndan çetde bolup, häkimiýet ugrunda göreşýän partiýalara näme partiýalar diýilýär?",
            "dolandyryjy partiýa", "ak partiýa", "oppozisiýadaky partiýalar", "syýasy partiýalar","oppozisiýadaky partiýalar"))
        soragList.add(SoragModel("Awstro Wengriýanyň hökümeti talapnamany Serbiýa haçan ýollady?",
            "1912-nji ýyl, 21-nji maý", "1915-nji ýyl, 24-nji awgust", "1914-nji ýyl, 23-nji iýul", "1913-nji ýyl, 22-nji iýun","1914-nji ýyl, 23-nji iýul"))
        soragList.add(SoragModel("Germaniýa Russiýa garşy haçan uruş yglan edýär?",
            "1914-nji ýyl, 1-nji awgust", "1916-nji ýyl, 8-nji oktýabr", "1917-nji ýyl, 14-nji noýabr", "1915-nji ýyl, 5-nji sentýabr","1914-nji ýyl, 1-nji awgust"))
        soragList.add(SoragModel("SSSR näçinji ýylda Milletler Ligasyna agzalyga giripdir?",
            "1930", "1926", "1938", "1934","1934"))
        soragList.add(SoragModel("Iosif Stalin 1929-njy ýyly näme ýyly diýip jar edipdir?",
            "Bereket ýyly", "Beýik öwrülişik ýyly", "Ösüş ýyly", "Üýtgeşmeler ýyly","Beýik öwrülişik ýyly"))
        soragList.add(SoragModel("Sowet-german gepleşikleri näçinji ýylda başlanýar?",
            "1939", "1944", "1949", "1953","1939"))
        soragList.add(SoragModel("Kolhoz gurluşygy näçinji ýylda tamamlanýar?",
            "1943", "1939", "1935", "1937","1937"))
        soragList.add(SoragModel("ABŞ SSSR-i naçinji ýylda ykrar edipdir?",
            "1933", "1930", "1938", "1934","1933"))
        soragList.add(SoragModel("Russiýa häkimiýet Sowetleriň eline haçan geçýär?",
            "1923-nji ýyl, 8-nji aprel", "1917-nji ýyl, 25-nji oktýabr", "1919-nji ýyl, 2-nji noýabr", "1926-nji ýyl, 30-njy iýun","1917-nji ýyl, 25-nji oktýabr"))




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