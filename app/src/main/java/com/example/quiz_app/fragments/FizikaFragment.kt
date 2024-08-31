package com.example.quiz_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.R
import com.example.quiz_app.model.matemAdapter
import com.example.quiz_app.model.model_formula
import java.util.*
import kotlin.collections.ArrayList

class FizikaFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private var matemList = ArrayList<model_formula>()
    private lateinit var adapter: matemAdapter
    private lateinit var searchView : androidx.appcompat.widget.SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_fizika, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewmatem)


        recyclerView.layoutManager = LinearLayoutManager(activity)
        searchView = view.findViewById(R.id.searchView)
        addDataToList()


        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }


    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<model_formula>()
            for (i in matemList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
               else if (i.at.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)

            }
            else {
                adapter.setFilteredList(filteredList)
            }



        }}



    private fun addDataToList() {
        matemList = ArrayList()
        matemList.add(model_formula(R.drawable.mehan, "Wektor komponentler", "Mehanika", R.drawable.wektorkomponentler))
        matemList.add(model_formula(R.drawable.mehan, "Hemişelik tizlik", "Mehanika", R.drawable.hemiseliktizlik))
        matemList.add(model_formula(R.drawable.mehan, "Hemişelik tizlenme", "Mehanika", R.drawable.hemiseliktizlenme))
        matemList.add(model_formula(R.drawable.mehan, "Erkin gaçma", "Mehanika", R.drawable.mugtyykylmak))
        matemList.add(model_formula(R.drawable.mehan, "Dik hereket", "Mehanika", R.drawable.dikhereket))
        matemList.add(model_formula(R.drawable.mehan, "Proýeksiýa hereket", "Mehanika", R.drawable.proyeksiyahereket))
        matemList.add(model_formula(R.drawable.mehan, "Birmeňzeş tegelek hereket", "Mehanika", R.drawable.birmenzestegelekhereket))
        matemList.add(model_formula(R.drawable.mehan, "Yzygiderli tizlenmäniň tegelek hereketi", "Mehanika", R.drawable.yzygidertizteghereketi))
        matemList.add(model_formula(R.drawable.mehan, "Nýutonyň kanunlary", "Mehanika", R.drawable.nutonkanuny))
        matemList.add(model_formula(R.drawable.mehan, "Iş energiýa we güýç", "Mehanika", R.drawable.isenergiyaweguyc))
        matemList.add(model_formula(R.drawable.mehan, "Çyzykly tizlik häsiýetleri", "Mehanika", R.drawable.cyzyklytizlikhasiyetleri))
        matemList.add(model_formula(R.drawable.mehan, "Aýlanma dinamikasy", "Mehanika", R.drawable.aylanmadinamikasy))
        matemList.add(model_formula(R.drawable.mehan, "Nýutonyň agyrlyk kanuny", "Mehanika", R.drawable.nutonynagyrlykkanuny))
        matemList.add(model_formula(R.drawable.suwuk, "Dykyzlyk, Belli agyrlyk güýji", "Suwuk mehanika", R.drawable.belliagyrlykguyji))
        matemList.add(model_formula(R.drawable.suwuk, "Bellibir göwrüm", "Suwuk mehanika", R.drawable.bellibirgowrum))
        matemList.add(model_formula(R.drawable.suwuk, "Basyş, Paskalyň kanuny", "Suwuk mehanika", R.drawable.basys))
        matemList.add(model_formula(R.drawable.suwuk, "Arhimediň ýörelgesi", "Suwuk mehanika", R.drawable.arhimedyorelge))
        matemList.add(model_formula(R.drawable.suwuk, "Akyş tizligi", "Suwuk mehanika", R.drawable.akystizligi))
        matemList.add(model_formula(R.drawable.suwuk, "Üznüksizlik deňlemesi", "Suwuk mehanika", R.drawable.uznuksizlikdenlemesi))
        matemList.add(model_formula(R.drawable.suwuk, "Bernolliniň deňlemesi", "Suwuk mehanika", R.drawable.bernollinindenlemesi))
        matemList.add(model_formula(R.drawable.suwuk, "Nasos, Hereketlendirijiniň güýji", "Suwuk mehanika", R.drawable.nasoshereketlendirijiguyc))
        matemList.add(model_formula(R.drawable.suwuk, "Umumy energiýa deňlemesi", "Suwuk mehanika", R.drawable.umumyenergiyadenlemesi))
        matemList.add(model_formula(R.drawable.tolkun, "Periodik, Burç ýygylygy", "Tolkunlar", R.drawable.periodikburcyygylygy))
        matemList.add(model_formula(R.drawable.tolkun, "Garmoniki hereket", "Tolkunlar", R.drawable.garmonikihereket))
        matemList.add(model_formula(R.drawable.tolkun, "Burç garmoniki hereket", "Tolkunlar", R.drawable.burcgarmonikihereketi))
        matemList.add(model_formula(R.drawable.tolkun, "Ýönekeý maýatnik", "Tolkunlar", R.drawable.yonekeymayatnik))
        matemList.add(model_formula(R.drawable.tolkun, "Fiziki maýatnik", "Tolkunlar", R.drawable.fizikimayatnik))
        matemList.add(model_formula(R.drawable.tolkun, "Sinusoidal tolkunlary", "Tolkunlar", R.drawable.sinusoidaltolkun))
        matemList.add(model_formula(R.drawable.tolkun, "Ses aýratynlyklary", "Tolkunlar", R.drawable.sesayratynlyklary))
        matemList.add(model_formula(R.drawable.termofizika, "Temperatura häsiýetleri", "Termodinamika", R.drawable.temperaturahasiyetleri))
        matemList.add(model_formula(R.drawable.termofizika, "Termiki stres", "Termodinamika", R.drawable.termikistres))
        matemList.add(model_formula(R.drawable.termofizika, "Ýylylyk fazasynyň üýtgemegi", "Termodinamika", R.drawable.yylylykfazasynynuytgem))
        matemList.add(model_formula(R.drawable.termofizika, "Ýylylyk geçiriji", "Termodinamika", R.drawable.yylylykgeciriji))
        matemList.add(model_formula(R.drawable.termofizika, "Ýylylyk giňelmesi", "Termodinamika", R.drawable.yylylykginelmesi))
        matemList.add(model_formula(R.drawable.termofizika, "Ýylylyk mukdary", "Termodinamika", R.drawable.yylylykmukdary))
        matemList.add(model_formula(R.drawable.termofizika, "Ideal gaz kanuny", "Termodinamika", R.drawable.idealgazkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Amperiň kanuny", "Elektromagnetizm", R.drawable.amperinkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Elektrik meýdany", "Elektromagnetizm", R.drawable.elektrikmeydany))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Elektrik potensial energiýasy", "Elektromagnetizm", R.drawable.elektrikpotensialenergiyasy))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Elektrik potensialy", "Elektromagnetizm", R.drawable.elektrikpotensialy))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Faradeýiň kanuny", "Elektromagnetizm", R.drawable.faradaykanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Gausyň kanuny", "Elektromagnetizm", R.drawable.gausynkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Kirçoftyň düzgüni", "Elektromagnetizm", R.drawable.kircoftynduzguni))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Kolombyň kanuny", "Elektromagnetizm", R.drawable.kolombkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Lorentyň kanuny", "Elektromagnetizm", R.drawable.lorentynkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Magnit akymynyň dykyzlygy", "Elektromagnetizm", R.drawable.magnitakymynyndykyzlygy))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Omuň kanuny", "Elektromagnetizm", R.drawable.omunkanuny))
        matemList.add(model_formula(R.drawable.elektromagnetizm, "Yzygiderli aýlaw", "Elektromagnetizm", R.drawable.yzygiderliaylaw))







        adapter = matemAdapter(matemList)
        recyclerView.adapter = adapter



    }}










