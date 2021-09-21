package com.example.crypto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crypto.R
import com.example.crypto.fragment.CoinPricefragment1
import com.example.crypto.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.item_coin_info.view.*


class CoinAdapter(private val context: CoinPricefragment1) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCoinClickListener: OnCoinClickListener? = null

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoCoin = itemView.ivLogoCoin
        val tvUpdate = itemView.tvUpdate
        val tvPrice = itemView.tvPrice
        val tvSymbols = itemView.tvSymbols

    }

    override fun onCrea