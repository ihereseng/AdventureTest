package com.example.adventuredemo.datasource

import com.example.adventuredemo.network.ProductAndBannerResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getProductAndBanner(): Response<ProductAndBannerResponse>
}