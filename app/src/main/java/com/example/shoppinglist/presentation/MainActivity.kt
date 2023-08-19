package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            shopListAdapter.shopList = it
        }
    }

    private fun setupRecyclerView(){
        shopListAdapter = ShopListAdapter()
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        rvShopList.adapter = shopListAdapter
        rvShopList.recycledViewPool.setMaxRecycledViews(R.layout.item_shop_enabled,ShopListAdapter.MAX_POOL_CAPACITY)
        rvShopList.recycledViewPool.setMaxRecycledViews(R.layout.item_shop_disabled,ShopListAdapter.MAX_POOL_CAPACITY)

    }


}