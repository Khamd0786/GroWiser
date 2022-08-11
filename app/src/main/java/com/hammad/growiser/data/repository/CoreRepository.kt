package com.hammad.growiser.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hammad.growiser.data.db.dao.FieldDao
import com.hammad.growiser.data.models.Field
import com.hammad.growiser.data.models.Grocery
import com.hammad.growiser.data.services.ApiService
import com.hammad.growiser.paging.GroceriesPagingSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CoreRepository {

    suspend fun fetchGroceriesWithFields(field: String?, query: String?): Flow<PagingData<Grocery>>
    fun getFields(): List<Field>

    class Impl @Inject constructor(
        private val apiService: ApiService,
        private val fieldDao: FieldDao
    ) : CoreRepository {

        override suspend fun fetchGroceriesWithFields(
            field: String?,
            query: String?
        ): Flow<PagingData<Grocery>> {
            val config = PagingConfig(10, 6, true, 10)
            delay(10)
            return Pager(config = config) {
                GroceriesPagingSource(apiService, fieldDao, field = field, query = query)
            }.flow
        }

        override fun getFields(): List<Field> {
            return fieldDao.getFields()
        }
    }
}
