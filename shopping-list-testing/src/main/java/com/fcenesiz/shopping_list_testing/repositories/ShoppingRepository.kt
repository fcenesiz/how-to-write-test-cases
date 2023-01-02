package com.fcenesiz.shopping_list_testing.repositories

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.fcenesiz.shopping_list_testing.data.local.ShoppingItem
import com.fcenesiz.shopping_list_testing.data.remote.responses.ImageResponse
import com.fcenesiz.shopping_list_testing.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>

}