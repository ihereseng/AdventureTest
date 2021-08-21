package com.example.adventuredemo.network

data class ProductAndBannerResponse(
    val banners: List<String>? = null,
    val products: List<Product>? = null
)
