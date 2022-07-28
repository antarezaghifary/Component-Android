package com.needcode.component.slider.versi1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.needcode.component.databinding.ActivitySlideBinding


class SlideActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySlideBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val imgList = ArrayList<SlideModel>()
            imgList.add(
                SlideModel(
                    "https://images.immediate.co.uk/production/volatile/sites/3/2019/04/Avengers-Endgame-Banner-2-de7cf60.jpg?quality=90&resize=620,413",
                    "Avengers Endgame"
                )
            )
            imgList.add(
                SlideModel(
                    "https://img.cinemablend.com/filter:scale/quill/3/7/0/0/8/e/37008e36e98cd75101cf1347396eac8534871a19.jpg?mw=600",
                    "Jumanji"
                )
            )
            imgList.add(
                SlideModel(
                    "https://www.adgully.com/img/800/201711/spider-man-homecoming-banner.jpg",
                    "Spider Man"
                )
            )
            imgList.add(
                SlideModel(
                    "https://live.staticflickr.com/1980/29996141587_7886795726_b.jpg",
                    "Venom"
                )
            )

            imageSlider.setImageList(imgList, ScaleTypes.FIT)
        }
    }

}