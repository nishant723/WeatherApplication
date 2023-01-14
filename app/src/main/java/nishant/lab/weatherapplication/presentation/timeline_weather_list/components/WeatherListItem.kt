package nishant.lab.weatherapplication.presentation.timeline_weather_list.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nishant.lab.weatherapplication.R
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nishant.lab.weatherapplication.comman.util.dateConverter
import nishant.lab.weatherapplication.data.remote.data_transfare_object.Day
import kotlin.math.roundToInt


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherListItem(
    day: Day
){ Column(
            modifier = Modifier
                .fillMaxWidth()) {
    Divider()
            Text(text = dateConverter(day.datetime.toString()),
                color = MaterialTheme.colors.primary, modifier = Modifier.padding(17.dp ),
            fontSize = 20.sp)
           Divider()


        }
    }

//}