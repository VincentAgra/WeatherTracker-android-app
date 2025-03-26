package persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import persistence.entities.ForecastResponseEntity

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecast: ForecastResponseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllForecasts(forecasts: List<ForecastResponseEntity>)

    @Query("SELECT * FROM forecast_table")
    suspend fun getAllForecasts(): List<ForecastResponseEntity>
}