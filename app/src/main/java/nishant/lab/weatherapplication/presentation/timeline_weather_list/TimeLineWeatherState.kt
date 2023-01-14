package nishant.lab.weatherapplication.presentation.timeline_weather_list

import nishant.lab.weatherapplication.domain.model.TimeLineWeather

data class TimeLineWeatherState(
    val isLoading: Boolean = false,
    val timeLineWeatherList: TimeLineWeather? = null,
    val error: String = ""
)
