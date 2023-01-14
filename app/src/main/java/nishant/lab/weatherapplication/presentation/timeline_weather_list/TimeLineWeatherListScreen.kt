package nishant.lab.weatherapplication.presentation.timeline_weather_list

import android.content.Context
import android.os.Build
import android.util.Log.d
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nishant.lab.weatherapplication.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import nishant.lab.weatherapplication.presentation.timeline_weather_list.components.WeatherCard
import nishant.lab.weatherapplication.presentation.timeline_weather_list.components.WeatherListItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeLineWeatherListScreen(viewModel: TimeLineWeatherViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.timeLineWeatherList?.let { timeLineWeatherList ->
            Column(
                modifier = Modifier
                    .background(color = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                        contentDescription = "",
                        Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Text(text = "")
                    Image(
                        painter = painterResource(id = R.drawable.ic_thermometer_com),
                        contentDescription = "",
                        Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_humidity_com),
                        contentDescription = "",
                        Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_wind), contentDescription = "",
                        Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize())
                {
                    items(timeLineWeatherList.days) { dailyWeather ->
                        WeatherListItem(day = dailyWeather)
                        WeatherCard(hour = dailyWeather.hours)

                    }

                }
            }

        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}