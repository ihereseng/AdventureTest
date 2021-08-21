package com.example.adventuredemo.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductAndBannerAPI {
    @GET("products")
    suspend fun getProductAndBanner(): Response<ProductAndBannerResponse>

    @POST("{product}")
    suspend fun getProductWDetail(
        @Path("product") product: String
    ): Response<ProductWDetail>
}