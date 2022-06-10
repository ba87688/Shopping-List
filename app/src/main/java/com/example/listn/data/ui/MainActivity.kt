package com.example.listn.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.listn.data.db.ShoppingDatabase
import com.example.listn.data.repository.ShoppingRepository
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





    }
}