package com.example.adventuredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.adventuredemo.component.loadImageUrl
import com.example.adventuredemo.databinding.ActivityDescriptionBinding
import com.example.adventuredemo.databinding.ActivityMainBinding
import com.example.adventuredemo.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding
    private val viewModel: DescriptionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolBar.onClickBack {
            finish()
        }
        showProgressBar()
        val arg = intent.extras?.getString("PRODUCT_URL")
        Log.d("DescriptionActivity", "arg: $arg")
        if (arg != null) {
            viewModel.getProductWDetail(arg)
            viewModel.productWDetail.observe(this) { response ->
                when (response) {
                    is Resource.Success -> {
                    hideProgressBar()
                        response.data?.let {
                            Log.i("MYTAG2", "came here ${it}")
                            binding.image.loadImageUrl(it.productImage)
                            binding.description.text = it.productDetail
                            binding.toolBar.setTitle(it.productName)
                        }
                    }
                    is Resource.Error -> {
                    hideProgressBar()
                        response.message?.let {
                            Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    is Resource.Loading -> {
                    showProgressBar()
                    }
                }
            }
        }
    }

    private fun showProgressBar() = run { binding.progressBar.visibility = View.VISIBLE }
    private fun hideProgressBar() = run { binding.progressBar.visibility = View.GONE }
}