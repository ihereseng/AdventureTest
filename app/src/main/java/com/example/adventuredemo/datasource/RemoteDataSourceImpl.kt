package com.example.adventuredemo.datasource

import com.example.adventuredemo.network.ProductAndBannerAPI
import com.example.adventuredemo.network.ProductWDetail
import retrofit2.Response


class RemoteDataSourceImpl(private val api: ProductAndBannerAPI) : RemoteDataSource {
    override suspend fun getProductAndBanner() = api.getProductAndBanner()
    override suspend fun getProductWDetail(productName: String) = api.getProductWDetail(productName)
}