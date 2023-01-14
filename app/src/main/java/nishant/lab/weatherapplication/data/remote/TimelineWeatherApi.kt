package nishant.lab.weatherapplication.data.remote

import nishant.lab.weatherapplication.data.remote.data_transfare_object.TimeLineWeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TimelineWeatherApi {
    @GET("timeline/{location}")
    suspend fun timeLineWeather(@Path("location")location:String,@Query("key")apikey:String):TimeLineWeatherDto
}