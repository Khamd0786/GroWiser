package com.hammad.growiser.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hammad.growiser.data.models.Field
import com.hammad.growiser.data.models.Grocery
import com.hammad.growiser.data.repository.CoreRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroceryViewModel @Inject constructor(private val repository: CoreRepository) : ViewModel() {

    private val _grocerySharedFlow = MutableSharedFlow<PagingData<Grocery>>()
    val groceryShareFlow = _grocerySharedFlow.asSharedFlow()
    
    var mField: String? = null
    var mQuery: String? = null
    var mFields: List<Field> = getFields()

    fun fetchGroceries() {
        viewModelScope.launch {
            repository.fetchGroceriesWithFields(mField, mQuery).cachedIn(viewModelScope)
                .collectLatest {
                    _grocerySharedFlow.emit(it)
                }
        }
    }

    private fun getFields(): List<Field> {
        val list  = repository.getFields().toMutableList()
        list.add(0, Field(id = "", "Select Field", type = ""))
        return list
    }

}