package com.example.adventuredemo.di

import com.example.adventuredemo.network.ApiService.provideOkHttpClient
import com.example.adventuredemo.network.ApiService.provideProductAndBannerAPI
import com.example.adventuredemo.network.ApiService.provideRetrofit
import org.koin.dsl.module

val appModule = module {
    //network
    factory { provideOkHttpClient() }
    factory { provideProductAndBannerAPI(get()) }
    single { provideRetrofit(get()) }
}