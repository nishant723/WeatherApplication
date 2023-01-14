package nishant.lab.weatherapplication.presentation.daily_weather.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import nishant.lab.weatherapplication.comman.util.convertFahrenheitToCelsius
import nishant.lab.weatherapplication.comman.util.dateConverter
import nishant.lab.weatherapplication.comman.util.dateConverterByDays
import nishant.lab.weatherapplication.comman.util.getDrawable
import nishant.lab.weatherapplication.data.remote.data_transfare_object.Day
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyWeatherCompose(day: Day) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider()
        Row(modifier = Modifier
            .padding(17.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(text = dateConverterByDays(day.datetime.toString()))
            Image(painter = painterResource(id = getDrawable("ic_"+day.icon!!.replace("-","_"),
                LocalContext.current)), contentDescription ="",Modifier.width(30.dp).height(30.dp))
            Text(text = convertFahrenheitToCelsius(day.tempmax!!).roundToInt().toString()+" °C/"+convertFahrenheitToCelsius(day.tempmin!!).roundToInt().toString()+" °C")
            Text(text = day.humidity.toString()+" %")
            Text(text = day.windspeed.toString()+" km/h")


        }
    }
}