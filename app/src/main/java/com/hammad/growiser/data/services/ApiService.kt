package com.hammad.growiser.data.services

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("resource/9ef84268-d588-465a-a308-a864a43d0070")
    fun getGroceries(
        @Query("api-key") key: String = "579b464db66ec23bdd000001fba66fb54b3148455a63078c9057e930",
        @Query("format") format: String ="json",
        @Query("offset") page: Int,
        @Query("limit") pageSize: Int
    )
}