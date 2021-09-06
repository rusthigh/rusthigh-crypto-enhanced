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
import kotlinx.coroutines.GlobalSc