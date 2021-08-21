package com.example.adventuredemo

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adventuredemo.network.ProductWDetail
import com.example.adventuredemo.usecase.GetProductWDetailUseCase
import com.example.adventuredemo.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionViewModel(
    private val app: AdventureApplication,
    private val getProductWDetailUseCase: GetProductWDetailUseCase
) :
    AndroidViewModel(app) {

    private val productWDetailRes: MutableLiveData<Resource<ProductWDetail>> =
        MutableLiveData()
    val productWDetail
        get() = productWDetailRes

    fun getProductWDetail(productUrl: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
//            if (isNetworkAvailable(app)) {

            val apiResult =
                getProductWDetailUseCase.execute(changeProductUrlToProductName(productUrl))
            productWDetailRes.postValue(apiResult)
//            } else {
//                productWDetailRes.postValue(Resource.Error("Internet is not available"))
//            }

        } catch (e: Exception) {
            Log.e("getProductWDetail", "getProductWDetail: $e")
            productWDetailRes.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun changeProductUrlToProductName(productUrl: String) =
        productUrl.split("/").toTypedArray().last()


}