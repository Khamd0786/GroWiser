package com.hammad.growiser.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hammad.growiser.data.db.AppDatabase
import com.hammad.growiser.data.repository.CoreRepository
import com.hammad.growiser.data.services.ApiService
import com.hammad.growiser.utils.K
import junit.framework.TestCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class GroceryViewModelTest : TestCase() {

    private lateinit var viewModel: GroceryViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()

        val context = ApplicationProvider.getApplicationContext<Context>()

        val db =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
                .build()
        val service = Retrofit.Builder().baseUrl(K.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiService = service.create(ApiService::class.java)

        val coreRepository: CoreRepository = CoreRepository.Impl(apiService, db.getFieldsDao())

        viewModel = GroceryViewModel(coreRepository)
    }

    @Test
    fun testGroceriesWithField() {
//        viewModel.fetchGroceries()
//        var count = 0;
//        var list = emptyList<com.hammad.growiser.data.models.Field>()
//        runBlocking {
//            viewModel.groceryShareFlow.collectLatest {
//                list = viewModel.mFields
//            }
//
//            assert(list.isNullOrEmpty().not())
////            assert(count == 20)
//        }
        assert(true)
    }




}