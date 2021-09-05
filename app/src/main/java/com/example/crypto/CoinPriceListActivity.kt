
package com.example.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crypto.fragment.CoinPricefragment1

class CoinPriceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coin_price_list_activity)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, CoinPricefragment1.newInstance())
            .addToBackStack(null)
            .commit()

             }


    }

