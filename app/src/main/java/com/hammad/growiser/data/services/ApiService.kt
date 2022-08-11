package com.hammad.growiser.data.services

import com.hammad.growiser.data.models.Grocery
import com.hammad.growiser.data.models.common.PaginatedBaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET("resource/9ef84268-d588-465a-a308-a864a43d0070")
    suspend fun getGroceries(
        @Query("api-key") key: String = "579b464db66ec23bdd000001fba66fb54b3148455a63078c9057e930",
        @Query("format") format: String = "json",
        @Query("offset") page: Int,
        @Query("limit") pageSize: Int,
        @Query("filters[]") filters: String
    ): Response<PaginatedBaseResponse<Grocery>>

    @GET
    suspend fun getGroceries(
        @Url url: String,
        @Query("api-key") key: String = "579b464db66ec23bdd000001fba66fb54b3148455a63078c9057e930",
        @Query("format") format: String = "json",
        @Query("offset") page: Int,
        @Query("limit") pageSize: Int
    ): Response<PaginatedBaseResponse<Grocery>>
}
