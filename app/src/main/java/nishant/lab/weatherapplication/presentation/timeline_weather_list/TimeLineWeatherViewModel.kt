package nishant.lab.weatherapplication.presentation.timeline_weather_list

import android.app.Application
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import nishant.lab.weatherapplication.comman.Constants
import nishant.lab.weatherapplication.comman.Resource
import nishant.lab.weatherapplication.domain.location.LocationTracker
import nishant.lab.weatherapplication.domain.use_case.get_timeline_weather.GetTimeLineWeatherUseCase
import javax.inject.Inject


@HiltViewModel
class TimeLineWeatherViewModel @Inject constructor(
    private val getTimeLineWeatherUseCase : GetTimeLineWeatherUseCase,
    saveStateHandle:SavedStateHandle,private val application: Application,
    private val locationTracker: LocationTracker
): ViewModel(){
       var _state = mutableStateOf(TimeLineWeatherState())
      var state : State<TimeLineWeatherState> = _state


    init {
        getTimeLineWeather()

    }

     fun getTimeLineWeather(){
         viewModelScope.launch {
             locationTracker.getCurrentLocation()?.let {
                 getTimeLineWeatherUseCase("${it.latitude},${it.longitude}",Constants.APIKEY).onEach { result->
                     when(result){
                         is Resource.Success->{
                             _state.value = TimeLineWeatherState(timeLineWeatherList = result.data)
                         }
                         is Resource.Error->{
                             _state.value = TimeLineWeatherState(error = result.message?:"An unexpected error occured")
                         }
                         is Resource.Loading->{
                             _state.value = TimeLineWeatherState(isLoading = true)

                         }
                     }
                 }.launchIn(viewModelScope)
             }
         }




    }





       


}


