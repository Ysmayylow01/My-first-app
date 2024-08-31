package com.example.quiz_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class ucAdapter (private var sozlukList:ArrayList<SOZLUKK>)
    : RecyclerView.Adapter<ucAdapter.ucViewHolder>(){

    var onItemClick : ((SOZLUKK) -> Unit)? = null

    class ucViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvTm: TextView = itemView.findViewById(R.id.tvTM)
        val tvEn: TextView = itemView.findViewById(R.id.tvEN)
        val tvRead: TextView = itemView.findViewById(R.id.tvRead)
        val cardView : CardView = itemView.findViewById(R.id.card)
        val tvId1: TextView = itemView.findViewById(R.id.tvId2)
    }
    fun  setFilteredList(sozlukList: ArrayList<SOZLUKK>){
        this.sozlukList= sozlukList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ucViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sozluk_item, parent , false)
        return ucViewHolder(view)
    }


    override fun onBindViewHolder(holder: ucViewHolder, position: Int) {
        val sozluk = sozlukList[position]

        holder.tvTm.text = sozluk.tm
        holder.tvEn.text = sozluk.en
        holder.tvRead.text = sozluk.read
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(sozluk)
            val bottomSheetDialog = BottomSheetDialog(holder.itemView.context)
            val view = LayoutInflater.from(holder.itemView.context)
                .inflate(R.layout.bottom_sheet, null)
            val tvENG: TextView = view.findViewById(R.id.tvENG)
            val tvTKM: TextView = view.findViewById(R.id.tvTKM)
            val tvREAD: TextView = view.findViewById(R.id.tvREAD)
            tvENG.text = sozluk.en
            tvTKM.text = sozluk.tm
            tvREAD.text = sozluk.read

            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
        }




        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))
    }

    override fun getItemCount(): Int {
        return sozlukList.size
    }



}
