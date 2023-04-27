package com.example.alphavantagecomposecrypto.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companyListingEntity")
data class CompanyListingEntity(
    val name : String,
    val symbol: String,
    val exchange: String,
    @PrimaryKey val id : Int ?= null
)