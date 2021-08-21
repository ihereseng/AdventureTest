package com.example.adventuredemo.network


import com.google.gson.annotations.SerializedName

data class ProductWDetail(
    @SerializedName("product_detail")
    val productDetail: String? = null,
    @SerializedName("product_image")
    val productImage: String? = null,
    @SerializedName("product_name")
    val productName: String? = null,
    @SerializedName("product_topic")
    val productTopic: String? = null
)