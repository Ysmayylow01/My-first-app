package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList



class bolumKitap: AppCompatActivity() {
    private lateinit var scrollView: ScrollView
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private var kitapList = ArrayList<KITAP>()
    private lateinit var KitapAdapter : kitapAdapter
    private lateinit var adapter: kitapAdapter
    private lateinit var baccc: ImageView
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bolum_kitap)
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        scrollView = findViewById(R.id.scrollView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()


          baccc= findViewById(R.id.baccc)
        baccc.setOnClickListener{

            onBackPressed()
        }

        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }




    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<KITAP>()
            for (i in kitapList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
                else if(i.awtor.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)
                Toast.makeText(this , getString(R.string.tapylmady) , Toast.LENGTH_SHORT).show()

            }
            else {
                adapter.setFilteredList(filteredList)
            }

        }}
    private fun addDataToList() {
        kitapList = ArrayList()
        kitapList.add(KITAP(R.drawable.mlnsyr, "Millioneriň syry","mark.Mil.pdf","Mark - Fişer"))
        kitapList.add(KITAP(R.drawable.beyni, "Beýniňi nädip güýçlendirmeli","beynininadipguyclendirmeli.pdf","Pol Bregg"))
        kitapList.add(KITAP(R.drawable.tmhan, "Türkmen hanlary we serdarlary","tmhan.pdf", ""))
        kitapList.add(KITAP(R.drawable.magtym, "Turan","turan.magt.pdf", "Magtymguly"))
        kitapList.add(KITAP(R.drawable.kerim, "Men ölmekden gorkýan","kerim-olmek.pdf", "Kerim - Hally"))
        kitapList.add(KITAP(R.drawable.deyl_dost, "Dosty neneňsi gazanmaly","dost-deyl.pdf", "Deýl - Karnegi"))
        kitapList.add(KITAP(R.drawable.fizika, "Fizika - Uniwersitet üçin","Fizika.pdf", ""))
        kitapList.add(KITAP(R.drawable.dsaa, "Data structure algorithms","dsa.pdf", ""))
        kitapList.add(KITAP(R.drawable.yediyaprak, "Ýedi ýaprak","k.gurban.yedi.pdf","Kerim Gurbannepesow"))
        kitapList.add(KITAP(R.drawable.infor_mese, "Informatika - meseleler ýygyndysy","Infor-mes.pdf", ""))
        kitapList.add(KITAP(R.drawable.c___, "C++ türkmen dilinde","c++.pdf", ""))
        kitapList.add(KITAP(R.drawable.eziz_han, "Eziz han hakda","rah.es.eziz.pdf","Rahym Esenow"))
        kitapList.add(KITAP(R.drawable.waww, "Wawilonyň iň baý adamy","waw.in.bay.pdf","Jorj Kleýson"))
        kitapList.add(KITAP(R.drawable.programir, "Web progromirleme dili","web.prog.pdf",""))
        kitapList.add(KITAP(R.drawable.oylan, "Oýlan hem baýa","oylan.baya.pdf","Napalýon Hil"))

        adapter = kitapAdapter(kitapList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, pdfActivity:: class.java)
            intent.putExtra("kitap", it)
            startActivity(intent)

        }




    }


}
