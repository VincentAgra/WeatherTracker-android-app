package models

data class ForecastResponse(
    val location: Location,
    val current: Current,
)