package com.example.alphavantagecomposecrypto.data.model

import java.time.LocalDateTime

data class IntradayInfo(
    val date: LocalDateTime,
    val close: Double
)
