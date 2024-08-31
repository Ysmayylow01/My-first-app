package com.example.quiz_app

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

class zehin_fizika : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
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



    private var backPressedTime: Long=0
    private var backToast : Toast? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zehin_fizika)

        toolbar=findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.fizika)

        gosmak=findViewById(R.id.gosmak)
        sorag=findViewById(R.id.sorag)
        jogap_A=findViewById(R.id.jogap_A)
        jogap_B=findViewById(R.id.jogap_B)
        jogap_C=findViewById(R.id.jogap_C)
        jogap_D=findViewById(R.id.jogap_D)
        dowam=findViewById(R.id.Dowam)


        soragList= ArrayList()
        soragList.add(SoragModel("15 m/s tizlik bilen gidip baryan ulag-da suruji, onunden bir it cykanda tormuza basyp 3 s-de duryar.Muna gora ulagyn yercekiminin mocberi nace m/s2-dir?",
            "8","7","3","5","5"))
        soragList.add(SoragModel("Birlik zamandaky tizlik calysmasy, Fizikada haysy termin bilen anladylar?.",
            "Ýerçekme","Salgy ýeri","Ýol","Tizlik","Ýerçekme"))
        soragList.add(SoragModel("Fizika asakdaky bilimlerden haysysyna has yakyn isler etmekdedir?",
            "Biologiýa","Himiýa","Matematika","Geografiýa","Himiýa"))
        soragList.add(SoragModel("Dunyanin towereginndaki sputniklara tasir eden kuwwat asakdakylardan haysysydyr?",
            "Güýçli ýadro kuwwat","Gowşak ýadro kuwwat","Massa üýtgediş kuwwat","Esas kuwwat","Massa üýtgediş kuwwat"))
        soragList.add(SoragModel("Asakdaky yagdaylaryn haysysynda fiziki taydan is edilmez?",
            "Ulagy itmek","Diwary 20N guyc bilen itmek","Sumkany merdiwandan yokary dasamak","Yerdaki topy yokary galdyrmak","Diwary 20N guyc bilen itmek"))
        soragList.add(SoragModel("Termometr bilen asakdaky gyzgynlyk olceglerinden haysysy olcelmez?",
            "-250 С","5000 K","1500 F","-50 K","-50 K"))
        soragList.add(SoragModel("Bir hereket edenin duran yeri belli bir nokada gora suratlandyrylar.Bu nokada ..... nokady diyiler.Yokardaky bosluga asakdakylaryn haysysy gelmeli?",
            "soňky","başlangyç","hereket","ýer üýtgeme","başlangyç"))
        soragList.add(SoragModel("Bir ulag 10m/s tizlik bilen gidende tizligini 3 s-da 25m/s-e yetiryar.Muna gora ulagyn yercekiminin moyberi nace m/s2-dir?",
            "5","4","3","6","5"))
        soragList.add(SoragModel("Asakdaky yagdaylaryn haysysynda yercekimine garsy is edilmekdedir?",
            "Ulagy itip akitmek","Welosiped surmek","Penjirani cekip acmak","Stanga goteren atletikajy","Ulagy itip akitmek"))
        soragList.add(SoragModel("Asakdaky yagdaylaryn haysysynda degme bolmadan bir kuwwat aktiwdir?",
            "Oyunjak ulagyn itilmesi","Motoryn wagonlary cekmesi","Almanyn agacdan yere gacmasy","Semalyn yapragy goparmasy","Almanyn agacdan yere gacmasy"))
        soragList.add(SoragModel("Broun hereketi haçan we kim tarapyndan açyldy?",
            "1827-nji ýylda I.Nýuton","1827-nji ýylda R.Broun","1824-nji ýylda A.Eýnşteýn","1825-nji ýylda W.Broun","1827-nji ýylda R.Broun"))
        soragList.add(SoragModel("2)Ýeriň atmosferasynyň basyşyny ilkinji gezek tejribede ölçän kim?",
            "Kawendiş","I.Nýuton","A.Eýnşteýin","Ewanjelista Torriçelli","Ewanjelista Torriçelli"))
        soragList.add(SoragModel("Paskal haçan suw sütünli barometri gurnady?",
            "1652ý","1675ý","1646ý","1658ý","1646ý"))
        soragList.add(SoragModel("4)Aýda erkin gaçmanyň tizlenmesi näçe?",
            "1,62m/s^2","1,45m/s^2","1,53m/s^2","1,89/s^2","1,62m/s^2"))
        soragList.add(SoragModel("Ýeriň radiusy näçe kilometr?",
            "6200km","6700km","7400km","6400km","6400km"))
        soragList.add(SoragModel("Grawitasiýa hemişeliginiň san bahasyny ilkinji gezek kim näçinji ýylda kesgitledi?",
            "1875,G.Kawendiş","I.Nýuton","1878,G.Kawendiş","1858,A.Eýnşteýn","1878,G.Kawendiş"))
        soragList.add(SoragModel("Ýeriň ilkinji emeli hemrasy haçan uçuryldy?",
            "1957,aprel 2","1957,oktýabr 4","1954,mart 4","1959,sentýabr 9","1957,oktýabr 4"))
        soragList.add(SoragModel("Ikinji kosmiki tizligi näçä deň?",
            "11,5km/s","11,2m/s","12,2km/s","11,2km/s","11,2km/s"))
        soragList.add(SoragModel("Kosmos giňişliginde ilkinji uçuşy kim haçan amala aşyrdy?",
            "Ý.A.Gagarin","Ž.Perren","D.Bernulli","G.Kawendiş","Ý.A.Gagarin"))
        soragList.add(SoragModel("Amerikan astronawtlary 6 gezek Aýa uçuşy haçan etdiler?",
            "1969–1972","1932–1962","1962–1975","1959–1971","1969–1972"))
        soragList.add(SoragModel("Ilkinji gezek peýdaly täsir koeffisiýenti, iş  diýen düşünjäni  kim  ylma girizýär?",
            "Ž.Perren","G.Galileý","A.Eýnşteýn","D.Bernulli","D.Bernulli"))
        soragList.add(SoragModel("Kim molekulalaryň bardygyny tejribe arkaly subut etdi?",
            "I.Nýuton","D.Mendeleýew","Ž.Perren","D.Bernuli","Ž.Perren"))
        soragList.add(SoragModel("«Gaz» diýen adalgany kim ylma girizdi?",
            "D.Bernulli","Wan-Gelmont","Ý.A.Gagarin","I.Nýuton","Wan-Gelmont"))
        soragList.add(SoragModel("Ilkinji termometri  kim näçinji ýylda ýasady?",
            "Wan-Gelmont","Ž.Perren","Ý.A.Gagarin","G.Galileý","G.Galileý"))
        soragList.add(SoragModel("Absolýut nol temperatura  ilkinji gezek haçan we kim tarapyndan kesgitlenildi?",
            "1848, Tomson (Kelwin)","1944, Ž.Perren","1843, I.Nýuton","1834, G.Galileý","1848, Tomson (Kelwin)"))



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