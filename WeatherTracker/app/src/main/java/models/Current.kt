package models

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("last_updated")
    val last_updated: String = "",
    @SerializedName("temp_c")
    val temp_c: Double,
    @SerializedName("temp_f")
    val temp_f: Double,
    @SerializedName("wind_mph")
    val wind_mph: Double,
    @SerializedName("wind_kph")
    val wind_kph: Double,
    @SerializedName("wind_dir")
    val wind_dir: String = "",
)



