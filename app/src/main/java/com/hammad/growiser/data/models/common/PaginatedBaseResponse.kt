package com.hammad.growiser.data.models.common

import com.google.gson.annotations.SerializedName
import com.hammad.growiser.data.models.Field

data class PaginatedBaseResponse<T>(
    @SerializedName("field") val fields: List<Field>,
    @SerializedName("total") val totalCount: Int,
    @SerializedName("limit") val pageSize: Int,
    @SerializedName("offset") val page: Int,
    @SerializedName("records") val docs: List<T>

)
