package com.example.quiz_app.model

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.FormActivity
import com.example.quiz_app.R


class matemAdapter(private var matemList:ArrayList<model_formula>)
    : RecyclerView.Adapter<matemAdapter.matemViewHolder>(){

    var onItemClick : ((model_formula) -> Unit)? = null

    class matemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imMat)
        val textView: TextView = itemView.findViewById(R.id.tvMat)
        val textView2: TextView=itemView.findViewById(R.id.tvMat2)
        val cardView : CardView = itemView.findViewById(R.id.card)
    }

    fun  setFilteredList(matemList: ArrayList<model_formula>){
        this.matemList= matemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): matemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.form_item, parent , false)
        return matemViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: matemViewHolder, position: Int) {
        val matem = matemList[position]
        holder.imageView.setImageResource(matem.image)
        holder.textView.text = matem.name
        holder.textView2.text = matem.at

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(matem)
            val intent = Intent(holder.itemView.context, FormActivity:: class.java)
            intent.putExtra("matem", matem)
            holder.itemView.context.startActivity(intent)
            }    }

    override fun getItemCount(): Int {
        return matemList.size
    }

}

