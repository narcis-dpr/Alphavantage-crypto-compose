package com.example.alphavantagecomposecrypto.data.repository

import com.example.alphavantagecomposecrypto.data.csv.CompanyListingsParser
import com.example.alphavantagecomposecrypto.data.local.StockDatabase
import com.example.alphavantagecomposecrypto.data.mapper.mapToCompanyListing
import com.example.alphavantagecomposecrypto.data.mapper.mapToCompanyListingEntity
import com.example.alphavantagecomposecrypto.data.model.CompanyListings
import com.example.alphavantagecomposecrypto.data.remote.StockApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val stockApi: StockApi,
    private val stockDatabase: StockDatabase,
    private val companyListingsParser: CompanyListingsParser

) : StockRepository {
    override suspend fun getCompanyListing(
        fromRemote: Boolean,
        query: String
    ): List<CompanyListings> {
        val localListing = stockDatabase.stockDao.searchInStockListings(query)
        val isDbEmpty = localListing.isEmpty() && query.isBlank()
        val fetchFromLocal = !isDbEmpty && !fromRemote
        if (fetchFromLocal)
            return localListing.map { it.mapToCompanyListing() }

        val response = stockApi.getListings()
        val responseParse = companyListingsParser.parse(response.byteStream())
        responseParse.let { listings ->
            stockDatabase.stockDao.deleteAllListings()
            stockDatabase.stockDao.saveCompanyListing(listings.map { it.mapToCompanyListingEntity() })
            return stockDatabase.stockDao.searchInStockListings("").map { it.mapToCompanyListing() }
        }

    }
}