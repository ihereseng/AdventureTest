package com.example.adventuredemo.usecase

import com.example.adventuredemo.repository.Repository
import retrofit2.Response

class GetProductWDetailUseCase(private val repository: Repository) {
    suspend fun execute(productName: String) = repository.getProductWDetail(productName)
}