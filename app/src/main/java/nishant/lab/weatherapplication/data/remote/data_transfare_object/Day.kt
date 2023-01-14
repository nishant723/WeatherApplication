package nishant.lab.weatherapplication.data.remote.data_transfare_object

import nishant.lab.weatherapplication.domain.model.TimeLineWeather

data class Day(
    val cloudcover: Double?=null,
    val conditions: String?=null,
    val datetime: String?=null,
    val datetimeEpoch: Int?=null,
    val description: String?=null,
    val dew: Double?=null,
    val feelslike: Double?=null,
    val feelslikemax: Double?=null,
    val feelslikemin: Double?=null,
    val hours: List<Hour>,
    val humidity: Double?=null,
    val icon: String?=null,
    val moonphase: Double?=null,
    val precip: Double?=null,
    val precipcover: Double?=null,
    val precipprob: Double?=null,
    val preciptype: List<String>?=null,
    val pressure: Double?=null,
    val severerisk: Double?=null,
    val snow: Double?=null,
    val snowdepth: Double?=null,
    val solarenergy: Double?=null,
    val solarradiation: Double?=null,
    val source: String?=null,
    val stations: List<String>?=null,
    val sunrise: String?=null,
    val sunriseEpoch: Int?=null,
    val sunset: String?=null,
    val sunsetEpoch: Int?=null,
    val temp: Double?=null,
    val tempmax: Double?=null,
    val tempmin: Double?=null,
    val uvindex: Double?=null,
    val visibility: Double?=null,
    val winddir: Double?=null,
    val windgust: Double?=null,
    val windspeed: Double?=null
)


