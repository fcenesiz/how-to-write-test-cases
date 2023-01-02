package com.fcenesiz.shopping_list_testing.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fcenesiz.shopping_list_testing.MainCoroutineRule
import com.fcenesiz.shopping_list_testing.getOrAwaitValue
import com.fcenesiz.shopping_list_testing.other.Constants
import com.fcenesiz.shopping_list_testing.other.Status
import com.fcenesiz.shopping_list_testing.repositories.FakeShoppingRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ShoppingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ShoppingViewModel


    @Before
    fun setUp() {
        viewModel = ShoppingViewModel(FakeShoppingRepository())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `insert shopping item with empty field, returns error`() {
        viewModel.insertShoppingItem(
            "name",
            "",
            "3.0"
        )

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with too long name, returns error`(){
        val name = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH + 1){
                append("x")
            }
        }
        viewModel.insertShoppingItem(
            name,
            "5",
            "3.0"
        )

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with too long price, returns error`(){
        val price = buildString {
            for (i in 1..Constants.MAX_PRICE_LENGTH + 1){
                append(1)
            }
        }
        viewModel.insertShoppingItem(
            "name",
            "5",
            price
        )

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with too high amount, returns error`(){
        viewModel.insertShoppingItem(
            "name",
            "999999999999999999999999",
            "3.0"
        )

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with valid input, returns error`(){
        viewModel.insertShoppingItem(
            "name",
            "5",
            "3.0"
        )

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }
}















