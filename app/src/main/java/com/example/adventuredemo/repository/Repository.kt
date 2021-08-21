package com.example.adventuredemo.repository

import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.util.Resource

interface Repository {
    suspend fun getProductAndBanner() : Resource<ProductAndBannerResponse>
}