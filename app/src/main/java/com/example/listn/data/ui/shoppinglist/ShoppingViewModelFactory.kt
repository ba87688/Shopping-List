package com.example.listn.data.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listn.data.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository:ShoppingRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return super.create(modelClass)
        return ShoppingViewModel(repository) as T
    }
}