package com.example.crypto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crypto.pojo.CoinPriceInfo

@Database(entities = [CoinPriceInfo::class], vers