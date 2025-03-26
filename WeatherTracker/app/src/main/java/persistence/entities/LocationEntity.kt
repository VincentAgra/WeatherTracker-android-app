package persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val localtime: String
)