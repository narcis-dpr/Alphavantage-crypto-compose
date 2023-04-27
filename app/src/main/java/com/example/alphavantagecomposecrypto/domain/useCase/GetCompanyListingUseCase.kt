package com.example.alphavantagecomposecrypto.domain.useCase

import com.example.alphavantagecomposecrypto.data.model.CompanyListings
import com.example.alphavantagecomposecrypto.data.repository.StockRepository
import com.example.alphavantagecomposecrypto.utiles.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCompanyListingUseCase @Inject constructor(
    private val stockRepository: StockRepository
) {
    operator fun invoke(
        query: String,
        fromRemote: Boolean
    ): Flow<ResultWrapper<List<CompanyListings>>> = flow {
        emit(ResultWrapper.Loading())
        try {
            emit(ResultWrapper.Success(stockRepository.getCompanyListing(fromRemote, query)))
        } catch (exception: IOException) {
            emit(ResultWrapper.Error(exception.message.toString(), null))
        } catch (exception: HttpException) {
            emit(ResultWrapper.Error(exception.message().toString(), null))
        }
    }
}