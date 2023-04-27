package com.example.alphavantagecomposecrypto.data.mapper

import com.example.alphavantagecomposecrypto.data.local.entites.CompanyListingEntity
import com.example.alphavantagecomposecrypto.data.model.CompanyListings


fun CompanyListingEntity.mapToCompanyListing(): CompanyListings {
    return CompanyListings(
        symbol = this.symbol,
        name = this.name,
        exchange = this.exchange
    )
}

fun CompanyListings.mapToCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name  = name,
        symbol = symbol,
        exchange = exchange,
    )
}