package com.example.adventuredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.adventuredemo.component.loadImageUrl
import com.example.adventuredemo.databinding.ActivityDescriptionBinding
import com.example.adventuredemo.databinding.ActivityMainBinding

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arg = intent.extras?.getString("PRODUCT_URL")
        Log.d("DescriptionActivity", "arg: $arg")
//        binding.image.loadImageUrl()
    }
}