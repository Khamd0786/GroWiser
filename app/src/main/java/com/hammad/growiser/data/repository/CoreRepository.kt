package com.hammad.growiser.data.repository

import com.hammad.growiser.data.db.dao.FieldDao
import com.hammad.growiser.data.services.ApiService
import javax.inject.Inject

interface CoreRepository {

    fun getData()

    class Impl @Inject constructor(private val apiService: ApiService,private val fieldDao: FieldDao): CoreRepository {
        override fun getData() {
                TODO("Not yet implemented")
        }

    }
}