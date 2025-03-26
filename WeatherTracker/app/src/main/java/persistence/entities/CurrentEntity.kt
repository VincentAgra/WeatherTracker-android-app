package persistence.entities

import android.graphics.drawable.Icon
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_table")
data class CurrentEntity(
    @PrimaryKey(autoGenerate = true)
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_dir: String,
)