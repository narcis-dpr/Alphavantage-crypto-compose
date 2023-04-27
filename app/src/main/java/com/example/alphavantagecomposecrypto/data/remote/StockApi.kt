package com.example.alphavantagecomposecrypto.data.remote

import com.example.alphavantagecomposecrypto.data.remote.dto.CompanyInfo
import com.example.alphavantagecomposecrypto.utiles.Constants
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {
    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apikey: String = Constants.API_KEY
    ) : ResponseBody

    @GET("query?function=TIME_SERIES_INTRADAY")
    suspend fun getIntraDay(
       @Query("symbol") symbol: String,
       @Query("interval") interval: String = Constants.FIVE_MIN,
       @Query("apikey") apikey: String = Constants.API_KEY
    ) : ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String = Constants.API_KEY
    ): CompanyInfo
}