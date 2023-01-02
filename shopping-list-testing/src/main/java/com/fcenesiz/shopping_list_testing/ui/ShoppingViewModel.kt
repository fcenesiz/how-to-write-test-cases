package com.fcenesiz.shopping_list_testing.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fcenesiz.shopping_list_testing.data.local.ShoppingItem
import com.fcenesiz.shopping_list_testing.data.remote.responses.ImageResponse
import com.fcenesiz.shopping_list_testing.other.Event
import com.fcenesiz.shopping_list_testing.other.Resource
import com.fcenesiz.shopping_list_testing.repositories.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: ShoppingRepository
): ViewModel() {

    val shoppingItems = repository.observeAllShoppingItems()
    val totalPrice = repository.observeTotalPrice()

    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images: LiveData<Event<Resource<ImageResponse>>> = _images

    private val _curImageUrl = MutableLiveData<String>()
    val curImageUrl: LiveData<String> = _curImageUrl

    private val _insertShoppingItemStatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemStatus: LiveData<Event<Resource<ShoppingItem>>> = _insertShoppingItemStatus

    fun setCurImageUrl(url: String){
        _curImageUrl.postValue(url)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertShoppingItem(name: String, amount: String, priceString: String){

    }

    fun searchForImage(imageQuery: String){

    }
}