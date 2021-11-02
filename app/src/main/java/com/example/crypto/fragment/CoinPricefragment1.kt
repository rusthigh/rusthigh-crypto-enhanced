package com.example.crypto.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.CoinPriceListActivity
import com.example.crypto.CoinViewModel
import com.example.crypto.R
import com.example.crypto.adapters.CoinAdapter
import com.example.crypto.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.coin_price_list_activity.*


class CoinPricefragment1 : Fragment() {
    private var viewModel: CoinViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_coin_pricefragment1, container, false)

        val adapter = CoinAdapter(this)
    