package nishant.lab.weatherapplication.presentation

import android.Manifest
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import nishant.lab.weatherapplication.presentation.bottom_navigation.mainScreen
import nishant.lab.weatherapplication.presentation.theme.WeatherApplicationTheme
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherListScreen
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherViewModel


@AndroidEntryPoint
class LunchActivity : ComponentActivity() {
   // private val viewModel: TimeLineWeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  fusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
          /*  val locationGPS: LocationManager =
               getSystemService(LocationManager.GPS_PROVIDER) as LocationManager*/
          //  viewModel.state

            //viewModel.getTimeLineWeather("25.78,84.75")
        }


      //  viewModel.getTimeLineWeather("25.78,84.75")
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        setContent {
            WeatherApplicationTheme {
                mainScreen()
            }
        }
    }

    fun getLastKnownLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location->
                if (location != null) {
                    // use your location object
                    // get latitude , longitude and other info from this
                }

            }

    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherApplicationTheme {

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.weatherListScreen.route
            ){
                composable(
                    route = Screen.weatherListScreen.route
                ){
                    TimeLineWeatherListScreen()
                }
            }

        }

    }
}
