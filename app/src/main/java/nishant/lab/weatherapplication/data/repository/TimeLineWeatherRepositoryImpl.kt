package nishant.lab.weatherapplication.data.repository

import nishant.lab.weatherapplication.data.remote.TimelineWeatherApi
import nishant.lab.weatherapplication.data.remote.data_transfare_object.TimeLineWeatherDto
import nishant.lab.weatherapplication.domain.repository.TimeLineWeatherRepository
import retrofit2.Response
import javax.inject.Inject

class TimeLineWeatherRepositoryImpl@Inject constructor(
    private val api :TimelineWeatherApi):TimeLineWeatherRepository{
    override suspend fun getTimeLineWeather(location: String, apikey: String): TimeLineWeatherDto{
        return api.timeLineWeather(location,apikey)
    }
}