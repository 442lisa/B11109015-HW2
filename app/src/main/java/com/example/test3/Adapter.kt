package com.example.test3

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test3.databinding.LocationItemBinding

class Adapter(private val itemlist:List<String>, private val listener: OnClickListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickListener{
        fun onItemClick(item: String)
    }

    inner class ItemViewHolder(private val itemBinding: LocationItemBinding):RecyclerView.ViewHolder(itemBinding.root){

        init {
            itemBinding.textView3.setOnClickListener{
                val position = adapterPosition
                listener.onItemClick(itemlist[position])
            }
        }

        fun bind(item:String){
            itemBinding.apply {
                textView3.text = item
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = LocationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
       return itemlist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(itemlist[position])
    }


}