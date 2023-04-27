package com.example.alphavantagecomposecrypto.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.alphavantagecomposecrypto.data.local.entites.CompanyListingEntity


@Dao
interface StockDao {
    @Insert
    suspend fun saveCompanyListing(companyListingEntities: List<CompanyListingEntity>)

    @Query("DELETE FROM companyListingEntity")
    suspend fun deleteAllListings()

    @Query(
        """
        SELECT * FROM companyListingEntity WHERE Lower(name) LIKE '%' || Lower(:query) || '%'
        OR UPPER(:query) ==symbol
        
    """
    )
    suspend fun searchInStockListings(query: String): List<CompanyListingEntity>
}