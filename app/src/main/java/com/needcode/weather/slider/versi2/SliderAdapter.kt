package com.needcode.weather.slider.versi2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView
import com.needcode.weather.R

class SliderAdapter internal constructor(
    sliderItem: MutableList<SliderItem>,
    viewPager2: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private val sliderItem: List<SliderItem>
    private val viewPager2: ViewPager2

    init {
        this.sliderItem = sliderItem
        this.viewPager2 = viewPager2
    }

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: RoundedImageView = itemView.findViewById(R.id.imgSlideItem)
        fun image(sliderItem: SliderItem) {
            image.setImageResource(sliderItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.image(sliderItem[position])
        if (position == sliderItem.size - 2) {
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return sliderItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        sliderItem.addAll(sliderItem)
        notifyDataSetChanged()
    }
}