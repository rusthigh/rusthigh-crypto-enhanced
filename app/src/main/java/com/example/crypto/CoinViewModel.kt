package com.example.crypto

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.crypto.api.ApiFactory
import com.example.crypto.database.AppDatabase
import com.example.crypto.pojo.CoinPriceInfo
import com.example.crypto.pojo.CoinPriceRAW
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    val priceList = db.coinPriceInfoDao().getPriceList()
    private val compositeDisposable = CompositeDisposable()

    init {
        GlobalScope.launch { loadData() }
    }


    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
    }

    private suspend fun loadData() {
        val topCoinPriceInfo = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
        val fsyms = topCoinPriceInfo.data?.map { it.coinInfo?.name }?.joinToString(",")
        val fullPriceList = fsyms?.let { ApiFactory.apiService.getFullPriceList(fSyms = it) }
        if (fullPriceList != null) {
            addToDataBase(fullPriceList)
        }
    }

    private fun addToDataBase(coinPriceRAW: CoinPriceRAW) {
        val keys = coinPriceRAW.coinPriceInfoObject?.keys
        val list = mutableListOf<CoinPriceInfo>()
        keys?.forEach { key ->
            coinPriceRAW.coinPriceInfoObject[key]?.get("USD")?.let { list.add(it) }
        }
        db.coinPriceInfoDao().insertPriceList(list)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
