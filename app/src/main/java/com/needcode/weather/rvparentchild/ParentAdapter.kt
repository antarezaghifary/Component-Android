package com.needcode.weather.rvparentchild

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.needcode.weather.R


class ParentAdapter internal constructor(
    activity: Activity,
    parentArrayList: MutableList<ParentItem>,
    childarrayList: MutableList<ChildItem>
) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val activity: Activity
    private val childItem: MutableList<ChildItem>
    private val parentItem: List<ParentItem>

    init {
        this.activity = activity
        this.childItem = childarrayList
        this.parentItem = parentArrayList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.tvOrderId)
        val qty: TextView = itemView.findViewById(R.id.tvqtyparent)
        val price: TextView = itemView.findViewById(R.id.tvpriceparent)
        val img: ImageView = itemView.findViewById(R.id.ivparent)
        val nested: RecyclerView = itemView.findViewById(R.id.nested_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_parent, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parentItem = parentItem[position]
        holder.orderId.text = parentItem.orderId
        holder.qty.text = "Quantity: " + parentItem.quantity
        holder.price.text = "Rs." + parentItem.price
        holder.img.setImageResource(parentItem.imageId)

        val childAdapter = ChildAdapter(childItem)
        val linearLayoutManager = LinearLayoutManager(activity)
        holder.nested.layoutManager = linearLayoutManager
        holder.nested.adapter = childAdapter
    }

    override fun getItemCount(): Int {
        return childItem.size
    }

}