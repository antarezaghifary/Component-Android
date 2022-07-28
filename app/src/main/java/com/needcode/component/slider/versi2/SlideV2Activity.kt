package com.needcode.component.slider.versi2

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.needcode.component.R
import com.needcode.component.databinding.ActivitySlideV2Binding
import kotlin.math.abs

class SlideV2Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySlideV2Binding.inflate(layoutInflater)
    }

    private val sliderHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val sliderItem: MutableList<SliderItem> = ArrayList()
            sliderItem.add(SliderItem(R.drawable.image1))
            sliderItem.add(SliderItem(R.drawable.image2))
            sliderItem.add(SliderItem(R.drawable.image3))

            imageSlider.adapter = SliderAdapter(sliderItem, imageSlider)

            imageSlider.clipToPadding = false
            imageSlider.clipChildren = false
            imageSlider.offscreenPageLimit = 3
            imageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositeTransform = CompositePageTransformer()
            compositeTransform.addTransformer(MarginPageTransformer(30))
            compositeTransform.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.25f
            }
            imageSlider.setPageTransformer(compositeTransform)

            imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRunnable)
                    sliderHandler.postDelayed(sliderRunnable, 3000)
                }
            })

        }
    }

    private val sliderRunnable = Runnable {
        binding.imageSlider.currentItem = binding.imageSlider.currentItem + 1
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.postDelayed(sliderRunnable, 3000)

    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }
}