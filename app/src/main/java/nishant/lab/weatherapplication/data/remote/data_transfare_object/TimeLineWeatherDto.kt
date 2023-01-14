package nishant.lab.weatherapplication.data.remote.data_transfare_object

import nishant.lab.weatherapplication.domain.model.TimeLineWeather

data class TimeLineWeatherDto(
    val address: String,
    val alerts: List<Any>,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val queryCost: Int,
    val resolvedAddress: String,
   // val stations: Stations,
    val timezone: String,
    val tzoffset: Double
)

fun TimeLineWeatherDto.toTimeLineWeather():TimeLineWeather{
    return TimeLineWeather(
         address = address,
        currentConditions = currentConditions,
        days=days,
        description = description,
        latitude=latitude,
        longitude=longitude,
        queryCost=queryCost,
        resolvedAddress=resolvedAddress,
        timezone=timezone

    )
}