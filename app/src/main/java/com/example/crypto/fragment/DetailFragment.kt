package com.example.crypto.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.crypto.CoinViewModel
import com.example.crypto.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_coin_info.*
import kotlinx.android.synthetic.main.item_coin_info.tvPrice
import kotlinx.android.synthetic.main.fragment_detail.ivLogoCoin

class DetailFragment : Fragment() {
    private var viewModel: CoinViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ii = requireArguments().getString(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProviders.of(this).get(CoinViewModel::class.java)
        if (ii != null) {
            viewModel?.getDetailInfo(ii)?.observe(viewLifecycleOwner, Observer {
                tvPrice.text = it.PRICE.toString()
                tvMinPrice.text = it.LOWDAY.toString()
                tvMaxPrice.text = it.HIGHDAY.toString()
                tvLastMarket.text = it.LASTMARKET.toString()
                tvLastUpdate.text = it.getFormatedTime()
                tvFromSymbol.text = it.FROMSYMBOL
                tvToSymbol.text = it.TOSYMBOL
                Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)

            })
        }
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
       private const val EXTRA_FROM_SYMBOL = "fSym"

        @JvmStatic
        fun newInstance(fromSymbol: String) = DetailFragment().apply {
            arguments = bundleOf(
                EXTRA_FROM_SYMBOL to fromSymbol
            )
        }

    }
}