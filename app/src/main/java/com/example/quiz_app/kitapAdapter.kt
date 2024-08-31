package com.example.quiz_app

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class kitapAdapter(private var kitapList:ArrayList<KITAP>)
    : RecyclerView.Adapter<kitapAdapter.kitapViewHolder>(){

    var onItemClick : ((KITAP) -> Unit)? = null

    class kitapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val awtor : TextView = itemView.findViewById(R.id.kitapAwtor)
        val cardView : CardView = itemView.findViewById(R.id.cardViewk)


        private val favoriteCheckbox: CheckBox= itemView.findViewById(R.id.favoriteButton)
        init {
            favoriteCheckbox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    Toast.makeText(itemView.context, "Halanlaryma goşuldy", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(itemView.context, "Halanlarymdan aýryldy", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }}
    fun  setFilteredList(kitapList: ArrayList<KITAP>){
        this.kitapList= kitapList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kitapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent , false)
        return kitapViewHolder(view)
    }

    override fun onBindViewHolder(holder: kitapViewHolder, position: Int) {
        val kitap = kitapList[position]
        holder.imageView.setImageResource(kitap.image)
        holder.textView.text = kitap.name
        holder.awtor.text = kitap.awtor


        holder.itemView.setOnClickListener{
            onItemClick?.invoke(kitap)

        }
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context, R.anim.slide_in))
    }

    override fun getItemCount(): Int {
        return kitapList.size
    }



}
