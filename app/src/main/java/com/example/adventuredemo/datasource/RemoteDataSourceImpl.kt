package com.example.adventuredemo.datasource

import com.example.adventuredemo.network.ProductAndBannerAPI


class RemoteDataSourceImpl(private val api: ProductAndBannerAPI) : RemoteDataSource {
    override suspend fun getProductAndBanner() = api.getProductAndBanner()
}