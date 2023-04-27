package com.example.alphavantagecomposecrypto.data.mapper

import com.example.alphavantagecomposecrypto.data.model.IntradayInfo
import com.example.alphavantagecomposecrypto.data.remote.dto.IntradayInfoDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun IntradayInfoDto.toIntradayInfo(): IntradayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return IntradayInfo(
        date = localDateTime,
        close = close
    )
}