package com.example.adventuredemo.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val baseUrl = "https://private-anon-1813af312e-iosadv.apiary-mock.com/"
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }

    fun provideProductAndBannerAPI(retrofit: Retrofit): ProductAndBannerAPI =
        retrofit.create(ProductAndBannerAPI::class.java)
}