package nishant.lab.weatherapplication.presentation.timeline_weather_list.components

import android.content.Context
import android.os.Build
import androidx.activity.contextaware.ContextAware
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import nishant.lab.weatherapplication.R
import nishant.lab.weatherapplication.comman.util.convertFahrenheitToCelsius
import nishant.lab.weatherapplication.comman.util.getDrawable
import nishant.lab.weatherapplication.data.remote.data_transfare_object.Day
import nishant.lab.weatherapplication.data.remote.data_transfare_object.Hour
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherState
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    hour: List<Hour>,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black
){ Column(
            modifier = Modifier
                .fillMaxWidth()
               , horizontalAlignment = Alignment.CenterHorizontally) {
   hour.forEach{data->
       Divider()
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(10.dp)
                         , horizontalArrangement = Arrangement.SpaceAround
                 ) {
                     Text(text = data.datetime!!.format(DateTimeFormatter.ofPattern("KK:mm")),
                         color = textColor)
                     Image(painter = painterResource(id = getDrawable("ic_"+data.icon!!.replace("-","_"),
                         LocalContext.current)), contentDescription = "",Modifier.width(30.dp).height(30.dp))
                     Text(text = convertFahrenheitToCelsius(data.temp!!).roundToInt().toString()+" °C")
                     Text(text = data.humidity.toString()+" %")
                     Text(text = data.windspeed.toString()+" km/h")
                 }


                }


        }





}