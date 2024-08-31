package com.example.quiz_app.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.*
import com.example.quiz_app.model.matemAdapter
import com.example.quiz_app.model.model_formula
import java.util.*
import kotlin.collections.ArrayList



class MatematikaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var matemList = ArrayList<model_formula>()
    private lateinit var searchView : androidx.appcompat.widget.SearchView

    private lateinit var adapter: matemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_matematika, container, false)


        recyclerView = view.findViewById(R.id.recyclerViewmatem)


        recyclerView.layoutManager = LinearLayoutManager(activity)
        searchView = view.findViewById(R.id.searchView)
        addDataToList()

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
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
             else if (i.at.lowercase(Locale.ROOT).contains(query)){

                filteredList.add(i)
            }

            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)



            } else {
                adapter.setFilteredList(filteredList)
                    }


        }
    }

}



    private fun addDataToList() {
        matemList = ArrayList()
        matemList.add(model_formula(R.drawable.basical, "Esasy formula","Algebra",R.drawable.esasyformulalar))
        matemList.add(model_formula(R.drawable.basical,"Görkezijili derejäniň häsiýetleri","Algebra", R.drawable.derejegorkeziji))
        matemList.add(model_formula(R.drawable.basical,"Derejäniň häsiýetleri","Algebra",R.drawable.derejehasiyetleri))
        matemList.add(model_formula(R.drawable.basical, "Gysga köpeltmek formulalar","Algebra",R.drawable.gysgakopeltmek))
        matemList.add(model_formula(R.drawable.basical, "Binomyň teoremasy","Algebra",R.drawable.binomynteoremasy))
        matemList.add(model_formula(R.drawable.basical, "Ady droplar","Algebra",R.drawable.adydroplar))
        matemList.add(model_formula(R.drawable.basical, "Deňlikler","Algebra",R.drawable.denlikler))
        matemList.add(model_formula(R.drawable.basical, "Kompleks sanlar","Algebra",R.drawable.komsanlar))
        matemList.add(model_formula(R.drawable.basical, "Kompleks sanlaryň häsiýetleri","Algebra",R.drawable.komplsanhas))
        matemList.add(model_formula(R.drawable.basical, "Kompleks sanlaryň ýazgysy","Algebra",R.drawable.kompsanynyazgysy))
        matemList.add(model_formula(R.drawable.basical, "Kwadrat deňlemäniň formulasy","Algebra",R.drawable.kwdenlekoklertapfor))
        matemList.add(model_formula(R.drawable.basical, "Logarifmiň häsiýetleri","Algebra",R.drawable.logarifmnhasi))
        matemList.add(model_formula(R.drawable.basical, "Jemleme teoremalary","Algebra",R.drawable.jemlemeteo))

        matemList.add(model_formula(R.drawable.geometri, "Köpburçluklar","Geometriýa",R.drawable.kopbur))
        matemList.add(model_formula(R.drawable.geometri, "Tegelek","Geometriýa",R.drawable.tegelek))
        matemList.add(model_formula(R.drawable.geometri, "Üçburçlugyň meýdany we perimetri","Geometriýa",R.drawable.ucburclukperimetr))
        matemList.add(model_formula(R.drawable.geometri, "Dörtburçluk","Geometriýa",R.drawable.dortbur))
        matemList.add(model_formula(R.drawable.geometri, "Geometrik jisimleriň göwrümi","Geometriýa",R.drawable.geometjisigowr))
        matemList.add(model_formula(R.drawable.geometri, "Iki nokadyň aralygy","Geometriýa",R.drawable.ikinokadynar))
        matemList.add(model_formula(R.drawable.geometri, "Göni çyzygyň deňlemesi","Geometriýa",R.drawable.gonicyzygyndenlemesi))
        matemList.add(model_formula(R.drawable.geometri, "Göni çyzygyň burç koefsiýenti","Geometriýa",R.drawable.gonicyzburkof))
        matemList.add(model_formula(R.drawable.geometri, "Iki nokadyň arasyndaky orta nokat","Geometriýa",R.drawable.ikinokadaraskyortanok))
        matemList.add(model_formula(R.drawable.geometri, "Töweregiň deňlemesi","Geometriýa",R.drawable.toweregindenlemesi))
        matemList.add(model_formula(R.drawable.geometri, "Ellips deňlemesi","Geometriýa",R.drawable.ellipsdenlemesi))
        matemList.add(model_formula(R.drawable.geometri, "Ellips merkezi","Geometriýa",R.drawable.ellipsmerkezi))
        matemList.add(model_formula(R.drawable.geometri, "Parabolanyň umumy deňlemesi","Geometriýa",R.drawable.parabolanynumumdenle))
        matemList.add(model_formula(R.drawable.geometri, "Giperbola deňlemesi","Geometriýa",R.drawable.giperboladenle))


        matemList.add(model_formula(R.drawable.trigon, "Pifagoryň teoremasy","Trigonometriýa",R.drawable.pifagorteor))
        matemList.add(model_formula(R.drawable.trigon, "Esasy trigonomertik formulalar","Trigonometriýa",R.drawable.esasytrigonomform))
        matemList.add(model_formula(R.drawable.trigon, "Trigonometrik funksiýalar","Trigonometriýa",R.drawable.trigonfunks))
        matemList.add(model_formula(R.drawable.trigon, "Napiýeriň teoremasy","Trigonometriýa",R.drawable.napierteorema))
        matemList.add(model_formula(R.drawable.trigon, "Burçlaryň trigonometrik funksiýalary","Trigonometriýa",R.drawable.umumburtrigfunk))
        matemList.add(model_formula(R.drawable.trigon, "Delambre Gausyň analogiýasy","Trigonometriýa",R.drawable.delamgausynanalogi))
        matemList.add(model_formula(R.drawable.trigon, "Burçlar üçin kosinuslar usuly","Trigonometriýa",R.drawable.burcucinkosinusul))
        matemList.add(model_formula(R.drawable.trigon, "Ýarym burç","Trigonometriýa",R.drawable.yarymburc))

        matemList.add(model_formula(R.drawable.linearalgebra, "Matrisaň häsiýetleri","Çyzykly algebra",R.drawable.matrisahasiyet))

        matemList.add(model_formula(R.drawable.integral, "Integralyň esasy häsiýetleri","Integral",R.drawable.integesasyhasiyet))
        matemList.add(model_formula(R.drawable.integral, "Rasional funksiýanyň integraly - 1","Integral",R.drawable.rasionalfunkintegraly1))
        matemList.add(model_formula(R.drawable.integral, "Rasional funksiýanyň integraly - 2","Integral",R.drawable.rasionalfunkintegraly2))
        matemList.add(model_formula(R.drawable.integral, "Trigonometik funksiýany integrirlemek - 1","Integral",R.drawable.trigonfunkintegrir1))
        matemList.add(model_formula(R.drawable.integral, "Trigonometik funksiýany integrirlemek - 2","Integral",R.drawable.trigonfunkintegrir2))
        matemList.add(model_formula(R.drawable.integral, "Trigonometik funksiýany integrirlemek - 3","Integral",R.drawable.trigonfunkintegrir3))
        matemList.add(model_formula(R.drawable.integral, "Dekart koordinatalar","Integral",R.drawable.dekartkoor))
        matemList.add(model_formula(R.drawable.integral, "Derejeli we logarifmik funksiýanyň integraly","Integral",R.drawable.derejeliwelogarffunkintegraly))
        matemList.add(model_formula(R.drawable.integral, "Differensial operator üýtgeýjisi","Integral",R.drawable.differensialoperatoruytgey))
        matemList.add(model_formula(R.drawable.integral, "Fubiniň teoremasy","Integral",R.drawable.fubininteoremasy))
        matemList.add(model_formula(R.drawable.integral, "Gausyň teoremasy","Integral",R.drawable.gausteorema))
        matemList.add(model_formula(R.drawable.integral, "Giperbolik funksiýanyň integraly","Integral",R.drawable.giperbolikfunkinteg))
        matemList.add(model_formula(R.drawable.integral, "Skalýar meýdany","Integral",R.drawable.skalyarmeydany))
        matemList.add(model_formula(R.drawable.integral, "Ugrukdyryjy önümler","Integral",R.drawable.ugrukdyryjyonumler))


        adapter = matemAdapter(matemList)
        recyclerView.adapter = adapter


    }}










