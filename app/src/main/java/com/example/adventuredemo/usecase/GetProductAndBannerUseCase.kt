package com.example.adventuredemo.usecase

import com.example.adventuredemo.repository.Repository
import retrofit2.Response

class GetProductAndBannerUseCase(private val repository: Repository) {
    suspend fun execute() = repository.getProductAndBanner()
}