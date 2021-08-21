package com.example.adventuredemo.di

import com.example.adventuredemo.AdventureApplication
import com.example.adventuredemo.MainViewModel
import com.example.adventuredemo.datasource.RemoteDataSource
import com.example.adventuredemo.datasource.RemoteDataSourceImpl
import com.example.adventuredemo.network.ApiService.provideOkHttpClient
import com.example.adventuredemo.network.ApiService.provideProductAndBannerAPI
import com.example.adventuredemo.network.ApiService.provideRetrofit
import com.example.adventuredemo.repository.Repository
import com.example.adventuredemo.repository.RepositoryImpl
import com.example.adventuredemo.usecase.GetProductAndBannerUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //network
    factory { provideOkHttpClient() }
    factory { provideProductAndBannerAPI(get()) }
    single { provideRetrofit(get()) }
    factory<GetProductAndBannerUseCase> { GetProductAndBannerUseCase(get<RepositoryImpl>() as Repository) }
    //DataSource
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
    //Repo
    single { RepositoryImpl(get()) }

    single { AdventureApplication() }
    //viewModel
    viewModel { MainViewModel(get(), get()) }
}