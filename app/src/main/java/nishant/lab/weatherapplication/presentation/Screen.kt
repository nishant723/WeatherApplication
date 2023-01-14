package nishant.lab.weatherapplication.presentation

sealed class Screen(val route:String){
    object weatherListScreen : Screen("weather_list")
    object weatherdetailsListScreen : Screen("weather_details_screen")

}
