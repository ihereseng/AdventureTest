package com.example.adventuredemo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adventuredemo.component.isNetworkAvailable
import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.network.ProductWDetail
import com.example.adventuredemo.usecase.GetProductAndBannerUseCase
import com.example.adventuredemo.usecase.GetProductWDetailUseCase
import com.example.adventuredemo.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val app: AdventureApplication,
    private val getProductAndBannerUseCase: GetProductAndBannerUseCase
) :
    AndroidViewModel(app) {

    private val productsAndBannerRes: MutableLiveData<Resource<ProductAndBannerResponse>> =
        MutableLiveData()

    val productAndBanner
        get() = productsAndBannerRes

    fun getProductsAndBanners() = viewModelScope.launch(Dispatchers.IO) {
        productsAndBannerRes.postValue(Resource.Loading())
        try {
//            if (isNetworkAvailable(app)) {

                val apiResult = getProductAndBannerUseCase.execute()
                productsAndBannerRes.postValue(apiResult)
//            }
//        else {
//                productsAndBannerRes.postValue(Resource.Error("Internet is not available"))
//            }

        } catch (e: Exception) {
            productsAndBannerRes.postValue(Resource.Error(e.message.toString()))
        }

    }
}