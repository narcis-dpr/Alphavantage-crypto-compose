package com.example.alphavantagecomposecrypto.presentation.event

sealed class CompanyListingEvent {
    object OnRefreshing : CompanyListingEvent()
    data class OnSearchQueryChange(
        val query: String
    ): CompanyListingEvent()
}