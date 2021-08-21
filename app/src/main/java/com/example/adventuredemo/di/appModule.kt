package com.example.adventuredemo.di

import com.example.adventuredemo.AdventureApplication
import com.example.adventuredemo.DescriptionViewModel
import com.example.adventuredemo.MainViewModel
import com.example.adventuredemo.datasource.RemoteDataSource
import com.example.adventuredemo.datasource.RemoteDataSourceImpl
import com.example.adventuredemo.network.ApiService.provideOkHttpClient
import com.example.adventuredemo.network.ApiService.provideProductAndBannerAPI
import com.example.adventuredemo.network.ApiService.provideRetrofit
import com.example.adventuredemo.repository.Repository
import com.example.adventuredemo.repository.RepositoryImpl
import com.example.adventuredemo.usecase.GetProductAndBannerUseCase
import com.example.adventuredemo.usecase.GetProductWDetailUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //network
    factory { provideOkHttpClient() }
    factory { provideProductAndBannerAPI(get()) }
    single { provideRetrofit(get()) }
    //UseCase
    factory { GetProductAndBannerUseCase(get<RepositoryImpl>() as Repository) }
    factory { GetProductWDetailUseCase(get<RepositoryImpl>() as Repository) }

    //DataSource
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
    //Repo
    single { RepositoryImpl(get()) }

    single { AdventureApplication() }
    //viewModel
    viewModel { MainViewModel(get(), get()) }
    viewModel { DescriptionViewModel(get(), get()) }

}