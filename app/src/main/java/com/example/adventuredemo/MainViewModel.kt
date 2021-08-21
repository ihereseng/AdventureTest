package com.example.adventuredemo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adventuredemo.network.ProductAndBannerResponse
import com.example.adventuredemo.usecase.GetProductAndBannerUseCase
import com.example.adventuredemo.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val app: AdventureApplication,
    private val getProductAndBannerUseCase: GetProductAndBannerUseCase
) :
    AndroidViewModel(app) {

    private val productsAndBanner: MutableLiveData<Resource<ProductAndBannerResponse>> =
        MutableLiveData()
    val getProductAndBanner
        get() = productsAndBanner

    fun test() {

    }

    fun getProductsAndBanners() = viewModelScope.launch(Dispatchers.IO) {
        productsAndBanner.postValue(Resource.Loading())
        try {
//            if (isNetworkAvailable(app)) {

            val apiResult = getProductAndBannerUseCase.execute()
            productsAndBanner.postValue(apiResult)
//            }
//        else {
//                productsAndBanner.postValue(Resource.Error("Internet is not available"))
//            }

        } catch (e: Exception) {
            productsAndBanner.postValue(Resource.Error(e.message.toString()))
        }

    }


    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}