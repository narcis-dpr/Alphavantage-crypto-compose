package com.example.alphavantagecomposecrypto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alphavantagecomposecrypto.data.local.StockDao
import com.example.alphavantagecomposecrypto.data.local.entites.CompanyListingEntity

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class StockDatabase: RoomDatabase() {
    abstract val stockDao: StockDao
}