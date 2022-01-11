
package com.example.crypto.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class CoinPriceRAW (
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoObject: Map<String,Map<String,CoinPriceInfo>>? = null
)