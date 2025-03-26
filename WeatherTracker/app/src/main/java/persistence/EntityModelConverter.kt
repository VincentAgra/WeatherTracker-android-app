package persistence

import models.Current
import models.ForecastResponse
import models.Location
import persistence.entities.CurrentEntity
import persistence.entities.ForecastResponseEntity
import persistence.entities.LocationEntity

object EntityModelConverter {

    fun convertToEntity(model: ForecastResponse): ForecastResponseEntity {
        return ForecastResponseEntity(
            location = LocationEntity(
                name = model.location.name,
                region = model.location.region,
                country = model.location.country,
                lat = model.location.lat,
                lon = model.location.lon,
                localtime = model.location.localtime
            ),
            current = CurrentEntity(
                last_updated = model.current.last_updated,
                temp_c = model.current.temp_c,
                temp_f = model.current.temp_f,
                wind_mph = model.current.wind_mph,
                wind_kph = model.current.wind_kph,
                wind_dir = model.current.wind_dir,)
        )
    }


    fun convertToModel(entity: ForecastResponseEntity): ForecastResponse {
        return ForecastResponse(
            location = Location(
                name = entity.location.name,
                region = entity.location.region,
                country = entity.location.country,
                lat = entity.location.lat,
                lon = entity.location.lon,
                localtime = entity.location.localtime
            ),
            current = Current(
                last_updated = entity.current.last_updated,
                temp_c = entity.current.temp_c,
                temp_f = entity.current.temp_f,
                wind_mph = entity.current.wind_mph,
                wind_kph = entity.current.wind_kph,
                wind_dir = entity.current.wind_dir,)
        )
    }
}