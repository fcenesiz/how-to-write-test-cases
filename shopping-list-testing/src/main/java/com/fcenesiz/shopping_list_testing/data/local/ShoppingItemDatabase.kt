package com.fcenesiz.shopping_list_testing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fcenesiz.shopping_list_testing.data.local.ShoppingDao

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}