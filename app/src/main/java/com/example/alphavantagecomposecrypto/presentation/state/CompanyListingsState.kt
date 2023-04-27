package com.example.alphavantagecomposecrypto.presentation.state

import com.example.alphavantagecomposecrypto.data.model.CompanyListings


data class CompanyListingsState(
    val companyListings: List<CompanyListings> ?= emptyList(),
    val isLoading: Boolean = false,
    val isRefresh: Boolean = false,
    val error: String ?= ""
)
