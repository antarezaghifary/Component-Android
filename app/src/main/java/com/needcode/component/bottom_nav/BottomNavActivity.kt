package com.needcode.component.bottom_nav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.needcode.component.R
import com.needcode.component.databinding.ActivityBottomNavBinding

class BottomNavActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityBottomNavBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val navController = findNavController(R.id.nav_host_fragment)
            binding.navView.setupWithNavController(navController)
        }
    }
}