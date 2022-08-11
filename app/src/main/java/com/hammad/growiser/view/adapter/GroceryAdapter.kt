package com.hammad.growiser.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hammad.growiser.R
import com.hammad.growiser.data.models.Grocery
import com.hammad.growiser.databinding.ItemGroceryBinding

class GroceryAdapter : PagingDataAdapter<Grocery, GroceryAdapter.VH>(Comparator) {

    inner class VH(private val binding: ItemGroceryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Grocery) {
            binding.apply {
                containerMarket.heading.text = binding.root.context.getString(R.string.market)
                containerMarket.data.text = item.market

                containerVariety.heading.text = binding.root.context.getString(R.string.variety)
                containerVariety.data.text = item.variety

                containerCommodity.heading.text = binding.root.context.getString(R.string.commodity)
                containerCommodity.data.text = item.commodity

                containerArrivalDate.heading.text = binding.root.context.getString(R.string.arrival_date)
                containerArrivalDate.data.text = item.arrival_date

                containerMinPrice.heading.text = binding.root.context.getString(R.string.min_price)
                containerMinPrice.data.text = item.min_price

                containerMaxPrice.heading.text = binding.root.context.getString(R.string.max_price)
                containerMaxPrice.data.text = item.max_price

                containerModalPrice.heading.text = binding.root.context.getString(R.string.modal_price)
                containerModalPrice.data.text = item.modal_price

                containerSector.heading.text = binding.root.context.getString(R.string.district)
                containerSector.data.text = item.district

                containerState.heading.text = binding.root.context.getString(R.string.state)
                containerState.data.text = item.state
            }
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    private object Comparator : DiffUtil.ItemCallback<Grocery>() {
        override fun areItemsTheSame(oldItem: Grocery, newItem: Grocery): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Grocery, newItem: Grocery): Boolean {
            return false
        }
    }
}
