package nishant.lab.weatherapplication.domain.repository

import nishant.lab.weatherapplication.data.remote.data_transfare_object.TimeLineWeatherDto

interface TimeLineWeatherRepository {
    suspend fun getTimeLineWeather(location:String,apikey:String):TimeLineWeatherDto
}