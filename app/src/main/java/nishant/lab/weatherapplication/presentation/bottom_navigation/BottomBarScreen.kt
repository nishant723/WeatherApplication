package nishant.lab.weatherapplication.presentation.bottom_navigation

import nishant.lab.weatherapplication.R

sealed class BottomBarScreen(var tital:String, var icon:Int, var screen_route:String){
    object Home:BottomBarScreen("Home", R.drawable.ic_baseline_home_24,"home")
    object TimeLine:BottomBarScreen("TimeLine", R.drawable.ic_baseline_access_time_24,"timeLine")
    object DaysForecast:BottomBarScreen("DaysForecast", R.drawable.ic_baseline_calendar_month_24,"daysForecast")
}
