package persistence.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "forecast_table")
data class ForecastResponseEntity(
    @Embedded
    val location: LocationEntity,
    @Embedded
    val current: CurrentEntity
) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}