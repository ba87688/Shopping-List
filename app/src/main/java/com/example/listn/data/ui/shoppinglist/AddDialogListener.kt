package com.example.listn.data.ui.shoppinglist

import com.example.listn.data.db.entity.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item:ShoppingItem)
}