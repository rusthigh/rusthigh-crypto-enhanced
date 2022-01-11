
package com.example.crypto.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.crypto.api.ApiFactory.BASE_URL_IMG
import com.example.crypto.utils.convertTime
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(

    @SerializedName("TYPE")
    var TYPE: String? = null,

    @SerializedName("MARKET")
    var MARKET: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    @NonNull
    var FROMSYMBOL: String,

    @SerializedName("TOSYMBOL")
    var TOSYMBOL: String? = null,

    @SerializedName("FLAGS")
    var FLAGS: String? = null,

    @SerializedName("PRICE")
    var PRICE: Double? = null,

    @SerializedName("LASTUPDATE")
    var LASTUPDATE: Long? = null,

    @SerializedName("MEDIAN")
    var MEDIAN: Double? = null,

    @SerializedName("LASTVOLUME")
    var LASTVOLUME: Double? = null,

    @SerializedName("LASTVOLUMETO")
    var LASTVOLUMETO: Double? = null,

    @SerializedName("LASTTRADEID")
    var LASTTRADEID: String? = null,

    @SerializedName("VOLUMEDAY")
    var VOLUMEDAY: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    var VOLUMEDAYTO: Double? = null,

    @SerializedName("VOLUME24HOUR")
    var VOLUME24HOUR: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    var VOLUME24HOURTO: Double? = null,