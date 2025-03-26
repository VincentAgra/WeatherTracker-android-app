package api

import WeatherApiService
import models.ForecastResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRetrofitApi {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    private val apiKeyInterceptor = Interceptor { chain ->
        val httpUrl = chain.request().url.newBuilder()
            .addQueryParameter("Key", "731ec8c5311a4c6186b21253232111")
            .build()

        val request = chain.request().newBuilder()
            .url(httpUrl)
            .build()

        chain.proceed(request)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(apiKeyInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherApiService: WeatherApiService = buildRetrofit().create(WeatherApiService::class.java)

    suspend fun getWeatherForecast(location: String?, days: Int): ForecastResponse {
        return weatherApiService.getWeatherForecast(location, days)
    }
}