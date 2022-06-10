package com.example.listn.data.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.listn.R
import com.example.listn.data.db.entity.ShoppingItem

class AddShoppingItemDialog(context:Context, var addDialogListener: AddDialogListener) :AppCompatDialog(context) {


    override fun onCreatePanelView(featureId: Int): View? {
        return super.onCreatePanelView(featureId)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        tvAdd?.setOnClickListener {

            val etName = findViewById<EditText>(R.id.etName)
            val name = etName?.text.toString()

            val a = findViewById<EditText>(R.id.etAmount)
            val amount = a?.text.toString()

            if (amount.isEmpty() || name.isEmpty()){
                Toast.makeText(context,"Please enter all info", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()

            val c = findViewById<TextView>(R.id.tvCancel)
            c?.setOnClickListener {
                cancel()
            }

        }
    }



}