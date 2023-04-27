package com.example.alphavantagecomposecrypto.data.repository

import com.example.alphavantagecomposecrypto.data.model.CompanyListings


interface StockRepository {
    suspend fun getCompanyListing(
        fromRemote: Boolean,
        query: String
    ): List<CompanyListings>
}