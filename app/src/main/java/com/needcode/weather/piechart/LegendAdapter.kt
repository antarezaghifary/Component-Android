package com.needcode.weather.piechart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.needcode.weather.R

class LegendAdapter(private var data: ArrayList<LegendModel>) :
    RecyclerView.Adapter<LegendAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_lagend, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.color.setBackgroundColor(data[position].color)
        holder.tvLabel.text = String.format(
            holder.itemView.context.getString(R.string.placeholder_lagend),
            data[position].label,
            data[position].value
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var color: View
        var tvLabel: TextView

        init {
            color = itemView.findViewById(R.id.vColor)
            tvLabel = itemView.findViewById(R.id.tvLabel)
        }
    }
}