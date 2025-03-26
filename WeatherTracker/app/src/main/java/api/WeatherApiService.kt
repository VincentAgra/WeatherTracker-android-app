import models.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("q") location: String?,
        @Query("days") days: Int,
    ): ForecastResponse
}