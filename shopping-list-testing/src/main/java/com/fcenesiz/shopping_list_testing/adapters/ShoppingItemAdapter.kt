package com.fcenesiz.shopping_list_testing.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.fcenesiz.shopping_list_testing.data.local.ShoppingItem
import com.fcenesiz.shopping_list_testing.databinding.ItemShoppingBinding
import javax.inject.Inject

class ShoppingItemAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    lateinit var binding: ItemShoppingBinding

    private val diffCallBack = object : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var shoppingItems: List<ShoppingItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        binding = ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val shoppingItem = shoppingItems[position]
        holder.itemView.apply {
            holder.binding.apply {
                glide.load(shoppingItem.imageUrl).into(ivShoppingImage)

                tvName.text = shoppingItem.name
                val amountText = "${shoppingItem.amount}x"
                tvShoppingItemAmount.text = amountText
                val priceText = "${shoppingItem.price}€"
                tvShoppingItemPrice.text = priceText
            }
        }
    }

    override fun getItemCount(): Int {
        return shoppingItems.size
    }

    class ShoppingItemViewHolder(val binding: ItemShoppingBinding) : RecyclerView.ViewHolder(binding.root)
}
