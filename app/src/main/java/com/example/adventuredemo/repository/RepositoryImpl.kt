package com.example.adventuredemo.repository

import com.example.adventuredemo.datasource.RemoteDataSource
import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.network.ProductWDetail
import com.example.adventuredemo.util.Resource
import retrofit2.Response

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun getProductAndBanner() =
        responseToResource(remoteDataSource.getProductAndBanner())

    override suspend fun getProductWDetail(productName: String) =
        responseToResourceWDetail(remoteDataSource.getProductWDetail(productName))

    private fun responseToResource(response: Response<ProductAndBannerResponse>): Resource<ProductAndBannerResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourceWDetail(response: Response<ProductWDetail>): Resource<ProductWDetail> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}