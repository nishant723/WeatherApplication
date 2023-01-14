package nishant.lab.weatherapplication.domain.use_case.get_timeline_weather

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nishant.lab.weatherapplication.comman.Resource
import nishant.lab.weatherapplication.data.remote.data_transfare_object.toTimeLineWeather
import nishant.lab.weatherapplication.domain.model.TimeLineWeather
import nishant.lab.weatherapplication.domain.repository.TimeLineWeatherRepository
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class GetTimeLineWeatherUseCase @Inject constructor(
    private val repository: TimeLineWeatherRepository
){
    operator fun invoke(location: String, apikey: String) : Flow<Resource<TimeLineWeather>> = flow {
        try {
            emit(Resource.Loading<TimeLineWeather>())
            val timeLineWeather = repository.getTimeLineWeather(location,apikey).toTimeLineWeather()
            emit(Resource.Success(timeLineWeather))
        }catch (e : HttpException){
            emit(Resource.Error<TimeLineWeather>(e.localizedMessage?:"An unexpected error occured "))
        }catch (e:IOException){
            emit(Resource.Error<TimeLineWeather>("Couldn,t reached server. Check your internet connection"))

        }
    }
}