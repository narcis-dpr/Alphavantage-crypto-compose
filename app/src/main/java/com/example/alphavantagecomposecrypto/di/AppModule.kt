package com.example.alphavantagecomposecrypto.di

import android.app.Application
import androidx.room.Room
import com.example.alphavantagecomposecrypto.data.local.StockDatabase
import com.example.alphavantagecomposecrypto.data.remote.StockApi
import com.example.alphavantagecomposecrypto.utiles.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            )
            .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .build()


    @Provides
    fun provideStockApi(retrofit: Retrofit): StockApi =
        retrofit.create(StockApi::class.java)


    @Provides
    @Singleton
    fun provideDatabase(app: Application): StockDatabase =
        Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            "stock.db"
        ).build()
}