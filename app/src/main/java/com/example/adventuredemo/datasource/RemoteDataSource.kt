package com.example.adventuredemo.datasource

import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.network.ProductWDetail
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getProductAndBanner(): Response<ProductAndBannerResponse>
    suspend fun getProductWDetail(productName: String): Response<ProductWDetail>

}