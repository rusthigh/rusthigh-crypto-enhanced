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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinInfoList[position]
        holder.itemView.setOnClickListener {
            onCoinClickListener?.onCoinClick(coin)
        }
        with(holder) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastTemplate = context.resources.getString(R.string.last_update_str)
            tvSymbols.text = String.format(symbolsTemplate, coin.FROMSYMBOL, coin.TOSYMBOL)
            tvPrice.text = coin.PRICE.toString()
            tvUpdate.text = String.format(lastTemplate, coin.getFormatedTime())
            Glide.with(context)
                .load(coin.getFullImageUrl())
                .into(holder.logoCoin)
        }

    }

    override fun getItemCount(): Int {
        return coinInfoList.size
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }


}
