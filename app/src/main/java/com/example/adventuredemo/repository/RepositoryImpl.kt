package com.example.adventuredemo.repository

import com.example.adventuredemo.datasource.RemoteDataSource
import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.util.Resource
import retrofit2.Response

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun getProductAndBanner() =
        responseToResource(remoteDataSource.getProductAndBanner())

    private fun responseToResource(response: Response<ProductAndBannerResponse>): Resource<ProductAndBannerResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}