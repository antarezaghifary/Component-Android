package com.needcode.weather.rvparentchild

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.needcode.weather.R


class ChildAdapter internal constructor(
    childarrayList: MutableList<ChildItem>
) : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    private val childItem: List<ChildItem>

    init {
        this.childItem = childarrayList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.tvItemName)
        val price: TextView = itemView.findViewById(R.id.tvpricechild)
        val qty: TextView = itemView.findViewById(R.id.tvqtychild)
        val img: ImageView = itemView.findViewById(R.id.ivChild)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_child, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val childItem = childItem[position]
        holder.itemName.text = childItem.itemName
        holder.qty.text = "Quantity: " + childItem.itemQty
        holder.price.text = "Rs." + childItem.itemPrice
        holder.img.setImageResource(childItem.imageID)
    }

    override fun getItemCount(): Int {
        return childItem.size
    }

}