package nishant.lab.weatherapplication.presentation.bottom_navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nishant.lab.weatherapplication.presentation.daily_weather.DailyWeather
import nishant.lab.weatherapplication.presentation.home.Home
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherListScreen
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(navController : NavHostController){

    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.screen_route){
         composable(route = BottomBarScreen.Home.screen_route){
             Home()
         }
        composable(route = BottomBarScreen.TimeLine.screen_route){
            TimeLineWeatherListScreen()
        }
        composable(route = BottomBarScreen.DaysForecast.screen_route){
          DailyWeather()
        }
    }

}