package com.example.adventuredemo.network

import retrofit2.Response
import retrofit2.http.GET

interface ProductAndBannerAPI {
    @GET("products")
    suspend fun getProductAndBanner(): Response<ProductAndBannerResponse>
}