
package com.example.crypto.api

import com.example.crypto.pojo.CoinInfoListOfData
import com.example.crypto.pojo.CoinPriceRAW
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TSIMBOL) tSym: String = QUERY_PARAM_CURRENCY,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "bcd9a7f860cf051f79ac147c33e5d934029759a50e3aa9cd305708c9f8aaf90b"
    ): CoinInfoListOfData

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_PARAM_TSIMBOLS) tSyms: String = QUERY_PARAM_CURRENCY,
        @Query(QUERY_PARAM_FSIMBOL) fSyms: String,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "bcd9a7f860cf051f79ac147c33e5d934029759a50e3aa9cd305708c9f8aaf90b"
    ):  CoinPriceRAW

    companion object {
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TSIMBOL = "tsym"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_CURRENCY = "USD"
        private const val QUERY_PARAM_FSIMBOL = "fsyms"
        private const val QUERY_PARAM_TSIMBOLS = "tsyms"
    }
}