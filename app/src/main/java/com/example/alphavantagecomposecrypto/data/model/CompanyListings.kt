package com.example.alphavantagecomposecrypto.data.model

import androidx.room.PrimaryKey

data class CompanyListings(
    val name: String,
    val symbol: String,
    val exchange: String,
)