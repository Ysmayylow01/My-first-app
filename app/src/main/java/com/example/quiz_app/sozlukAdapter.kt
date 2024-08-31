package com.example.quiz_app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils

import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class sozlukAdapter(private var sozlukList:ArrayList<SOZLUKK>)
    : RecyclerView.Adapter<sozlukAdapter.sozlukViewHolder>(){



    class sozlukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvTm: TextView = itemView.findViewById(R.id.tvTM)
        val tvEn: TextView = itemView.findViewById(R.id.tvEN)
        val tvRead: TextView = itemView.findViewById(R.id.tvRead)
        val cardView : CardView = itemView.findViewById(R.id.card)
    }

    fun  setFilteredList(sozlukList: ArrayList<SOZLUKK>){
        this.sozlukList= sozlukList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sozlukViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sozluk_item, parent , false)
        return sozlukViewHolder(view)
    }


    override fun onBindViewHolder(holder: sozlukViewHolder, position: Int) {
        val sozluk = sozlukList[position]
        holder.tvTm.text = sozluk.tm
        holder.tvEn.text = sozluk.en
        holder.tvRead.text = sozluk.read



        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))
    }

    override fun getItemCount(): Int {
        return sozlukList.size
    }



}
