package com.hammad.growiser.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hammad.growiser.data.db.dao.FieldDao
import com.hammad.growiser.data.models.Grocery
import com.hammad.growiser.data.services.ApiService
import com.hammad.growiser.network.NetworkRequest
import com.hammad.growiser.utils.K
import com.hammad.growiser.utils.UrlUtils

class GroceriesPagingSource(
    private val service: ApiService,
    private val fieldDb: FieldDao,
    private var field: String?,
    private var query: String?
) : PagingSource<Int, Grocery>() {

    private var nextKey: Int? = 1
    override fun getRefreshKey(state: PagingState<Int, Grocery>): Int {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Grocery> {
        val key = params.key ?: 1
        try {
            val data = NetworkRequest.process {
                val url = UrlUtils.appendFilter(K.BASE_PATH, field, query)

                service.getGroceries(url = url, page = key, pageSize = params.loadSize)
            }.run {
                when (this) {
                    is NetworkRequest.ApiResponse.Success ->
                        data ?: throw Exception("Error fetching groceries")
                    else -> throw Exception("Error fetching groceries")
                }
            }

            nextKey = if (data.docs.isNullOrEmpty()) null else data.page + 1

            // caching all fields into the database
            fieldDb.insert(*data.fields.toTypedArray())

            Log.d("TAG", "load: $data")
            return LoadResult.Page(data.docs, null, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}
