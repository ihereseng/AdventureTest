package com.example.adventuredemo.network

import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("product_name")
    val productName: String? = null,
    @SerializedName("product_topic")
    val productTopic: String? = null,
    @SerializedName("product_image")
    val productImage: String? = null,
    @SerializedName("product_url")
    val productUrl: String? = null
)
