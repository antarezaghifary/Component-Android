package com.needcode.weather.Chip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.needcode.weather.databinding.ActivityChipBinding

class ChipActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityChipBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {

        }
    }
}