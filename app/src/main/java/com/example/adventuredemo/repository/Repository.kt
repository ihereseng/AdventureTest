package com.example.adventuredemo.repository

import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.network.ProductWDetail
import com.example.adventuredemo.util.Resource
import retrofit2.Response

interface Repository {
    suspend fun getProductAndBanner() : Resource<ProductAndBannerResponse>
    suspend fun getProductWDetail(productName: String): Resource<ProductWDetail>
}