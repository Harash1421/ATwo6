package com.timer.atwo3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rc_layout.view.*
import kotlin.collections.List

class Adapter(var context: Context, var list:List<com.timer.atwo3.List>, var onClick:OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    interface OnClickListener{
        fun onClick(position:Int, image:Int, description:String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShowAdapter(LayoutInflater.from(context).inflate(R.layout.rc_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShowAdapter).show(list[position].AnimalPhoto, list[position].AnimalName)

        //Click On Items
        holder.itemView.tvImage.setOnClickListener {
            onClick.onClick(list[position].Id, list[position].AnimalPhoto, list[position].description)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
class ShowAdapter(itemView:View) : RecyclerView.ViewHolder(itemView){
    fun show(Ap:Int ,An:String){
        itemView.tvImage.setImageResource(Ap)
        itemView.tvName.text = An
    }
}
}