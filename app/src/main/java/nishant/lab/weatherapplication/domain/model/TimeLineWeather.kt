package nishant.lab.weatherapplication.domain.model

import nishant.lab.weatherapplication.data.remote.data_transfare_object.CurrentConditions
import nishant.lab.weatherapplication.data.remote.data_transfare_object.Day

data class TimeLineWeather(
    val address: String,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val queryCost: Int,
    val resolvedAddress: String,
    val timezone: String)


