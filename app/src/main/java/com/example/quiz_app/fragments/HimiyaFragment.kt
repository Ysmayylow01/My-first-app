package com.example.quiz_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.R
import com.example.quiz_app.databinding.FragmentMatematikaBinding
import com.example.quiz_app.model.matemAdapter
import com.example.quiz_app.model.model_formula
import java.util.*
import kotlin.collections.ArrayList



class HimiyaFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var matemList = ArrayList<model_formula>()
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private lateinit var adapter: matemAdapter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_himiya, container, false)

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
    matemList.add(model_formula(R.drawable.stoiometri, "Himiki reaksiýalaryň görnüşi","Stohiometriýa",R.drawable.himikireaksgornus))
    matemList.add(model_formula(R.drawable.stoiometri,"Esasy stohiometriýa", "Stohiometriýa",R.drawable.esasystohiometriya))
    matemList.add(model_formula(R.drawable.stoiometri,"Stohimetriýanyň hasaplamalary", "Stohiometriýa",R.drawable.stohiometriyanynhasap))
    matemList.add(model_formula(R.drawable.ergin,"Erginiň konsentrasiýasy", "Erginler",R.drawable.ergininkonsentr))
    matemList.add(model_formula(R.drawable.ergin,"Molarity, molality we Molar fraksiýasy", "Erginler",R.drawable.molaritywemolar))
    matemList.add(model_formula(R.drawable.ergin,"Suwuklyk", "Erginler",R.drawable.suwuklyk))
    matemList.add(model_formula(R.drawable.ergin,"pH terezisi", "Erginler",R.drawable.phterezi))
    matemList.add(model_formula(R.drawable.elektrohimiya,"Elektro himiýa", "Elektro himiýa",R.drawable.elektro_himiya))
    matemList.add(model_formula(R.drawable.termohimiya,"Kalorimetriýa", "Termo-himiýa",R.drawable.kalorimetr))
    matemList.add(model_formula(R.drawable.termohimiya,"Entalpiýa we entropiýa", "Termo-himiýa",R.drawable.entalpiyaweentropiya))
    matemList.add(model_formula(R.drawable.gaz,"Ideal gazyň kanuny", "Gaz",R.drawable.idealgazynkanuny))
    matemList.add(model_formula(R.drawable.gaz,"Daltonyň kanuny we bölegi", "Gaz",R.drawable.daltonkanuny))
    matemList.add(model_formula(R.drawable.gaz,"Grahamyň kanuny", "Gaz",R.drawable.grahamynkanuny))
    matemList.add(model_formula(R.drawable.gaz,"Kök ortaça kwadrat tizligi", "Gaz",R.drawable.kokkwadrattizanladyar))
    matemList.add(model_formula(R.drawable.gaz,"Van Der Waals deňlemesi", "Gaz",R.drawable.wanderwalsdenleme))
    matemList.add(model_formula(R.drawable.gaz,"Gysyş faktory", "Gaz",R.drawable.gysysfaktor))



    adapter = matemAdapter(matemList)
    recyclerView.adapter = adapter



}}










