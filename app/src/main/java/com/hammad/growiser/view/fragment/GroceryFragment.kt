package com.hammad.growiser.view.fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.hammad.growiser.GroWiserApp
import com.hammad.growiser.databinding.FragmentGroceryBinding
import com.hammad.growiser.di.ViewModelFactory
import com.hammad.growiser.view.adapter.GroceryAdapter
import com.hammad.growiser.viewmodel.GroceryViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

const val INIT_DELAY: Long = 300L
class GroceryFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel by viewModels<GroceryViewModel> { factory }

    private lateinit var binding: FragmentGroceryBinding
    private lateinit var adapter: GroceryAdapter

    private lateinit var mSpinner: ArrayAdapter<String>

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GroWiserApp.get().appComponent.inject(this)
        adapter = GroceryAdapter()

        viewModel.fetchGroceries()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroceryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
        bindListener()
        bindObserver()
    }

    private fun bindView() {
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = adapter

        initSpinnerAdapter() // initializing spinner adapter
    }

    private fun bindListener() {
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.mField = viewModel.mFields[p2].id
                viewModel.fetchGroceries() // fetching groceries when type got changed
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        binding.searchView.setOnQueryTextListener(object :
                SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(newText: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    viewModel.mQuery = query
                    searchDebouncedQuery()
                    return false
                }
            })
    }

    private fun initSpinnerAdapter() {
        val fields = viewModel.mFields.map { it.name }
        mSpinner = ArrayAdapter(context ?: return, R.layout.simple_spinner_item, fields)
        binding.spinner.adapter = mSpinner
    }

    /**
     * This function will execute the new calls only and wait for a specific time period
     */
    private fun searchDebouncedQuery() {
        job?.cancel()
        job = lifecycleScope.launchWhenCreated {
            delay(INIT_DELAY)
            viewModel.fetchGroceries()
        }
    }

    private fun bindObserver() {
        lifecycleScope.launchWhenCreated {
            viewModel.groceryShareFlow.collectLatest {
                adapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest {
                binding.loader.isVisible = it.refresh is LoadState.Loading
            }
        }
    }
}
