package com.example.listn.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listn.data.adapter.ShoppingItemAdapter
import com.example.listn.data.db.ShoppingDatabase
import com.example.listn.data.db.entity.ShoppingItem
import com.example.listn.data.repository.ShoppingRepository
import com.example.listn.data.ui.shoppinglist.AddDialogListener
import com.example.listn.data.ui.shoppinglist.AddShoppingItemDialog
import com.example.listn.data.ui.shoppinglist.ShoppingViewModel
import com.example.listn.data.ui.shoppinglist.ShoppingViewModelFactory
import com.example.listn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory  = ShoppingViewModelFactory(repository )
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)


        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this,object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }





    }
}