package com.hammad.growiser.data.models

import com.google.gson.annotations.SerializedName

data class Grocery(
    @SerializedName("arrival_date") val arrival_date: String,
    @SerializedName("commodity") val commodity: String,
    @SerializedName("district") val district: String,
    @SerializedName("market") val market: String,
    @SerializedName("max_price") val max_price: String,
    @SerializedName("min_price") val min_price: String,
    @SerializedName("modal_price") val modal_price: String,
    @SerializedName("state") val state: String,
    @SerializedName("variety") val variety: String
)
