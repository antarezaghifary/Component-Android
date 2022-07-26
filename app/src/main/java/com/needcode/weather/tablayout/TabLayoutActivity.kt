package com.needcode.weather.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.needcode.weather.databinding.ActivityTabLayoutBinding

class TabLayoutActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTabLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val adapter = TabLayoutAdapter(supportFragmentManager, lifecycle)
            viewPager2.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "First"
                    }

                    1 -> {
                        tab.text = "Second"

                    }

                    2 -> {
                        tab.text = "Third"
                    }
                }
            }.attach()
        }
    }
}