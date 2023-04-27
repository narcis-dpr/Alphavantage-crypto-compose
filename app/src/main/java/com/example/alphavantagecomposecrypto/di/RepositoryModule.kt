package com.example.alphavantagecomposecrypto.di

import com.example.alphavantagecomposecrypto.data.csv.CSVParser
import com.example.alphavantagecomposecrypto.data.csv.CompanyListingsParser
import com.example.alphavantagecomposecrypto.data.csv.IntradayInfoParser
import com.example.alphavantagecomposecrypto.data.model.CompanyListings
import com.example.alphavantagecomposecrypto.data.model.IntradayInfo
import com.example.alphavantagecomposecrypto.data.repository.StockRepository
import com.example.alphavantagecomposecrypto.data.repository.StockRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListings>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepositroy(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}