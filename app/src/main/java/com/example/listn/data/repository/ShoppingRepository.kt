package com.example.listn.data.repository

import androidx.lifecycle.LiveData
import com.example.listn.data.db.ShoppingDatabase
import com.example.listn.data.db.entity.ShoppingItem

class ShoppingRepository (private val db:ShoppingDatabase){

    suspend fun upsert(item:ShoppingItem){
        db.getShoppingDao().upsert(item)
    }

    suspend fun delete(item: ShoppingItem){
        db.getShoppingDao().delete(item)

    }
    fun getAllItems()=db.getShoppingDao().getAllItems()

}