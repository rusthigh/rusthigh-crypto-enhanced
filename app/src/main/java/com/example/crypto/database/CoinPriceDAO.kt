package com.example.crypto.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.crypto.pojo.CoinPriceInfo

@Dao
interface CoinPriceDAO {
    @Query("SELECT * FROM full_price_list ORDER BY LASTUPDATE DESC")
    fun getPriceList():LiveData<List<CoinPriceInfo>>

    @Query ("SELECT * FROM full_price_list WHERE FROMSYMBOL == :fSym LIM