package nishant.lab.weatherapplication.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import nishant.lab.weatherapplication.comman.util.convertFahrenheitToCelsius
import nishant.lab.weatherapplication.comman.util.getDrawable
import nishant.lab.weatherapplication.data.remote.data_transfare_object.CurrentConditions
import nishant.lab.weatherapplication.domain.model.TimeLineWeather
import nishant.lab.weatherapplication.presentation.home.components.RowItems
import nishant.lab.weatherapplication.presentation.home.components.RowItemsString
import nishant.lab.weatherapplication.presentation.timeline_weather_list.TimeLineWeatherViewModel
import kotlin.math.roundToInt

@Composable
fun Home(viewModel: TimeLineWeatherViewModel = hiltViewModel()){
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp), contentAlignment = Alignment.Center){
        state.timeLineWeatherList?.let {
            Card(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {
                LazyColumn(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    item {
                        Text(text = it.resolvedAddress!!)
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(painter = painterResource(id = getDrawable("ic_"+it.currentConditions.icon!!.replace("-","_"),
                            LocalContext.current)), contentDescription ="" )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Today's Details", fontStyle = FontStyle.Normal)
                        Spacer(modifier = Modifier.height(10.dp))
                        Spacer(modifier = Modifier.height(16.dp))
                        RowItems(itemName = "Temperature", itemValue = convertFahrenheitToCelsius(it.currentConditions.temp!!).roundToInt(), unit = " °C")
                        RowItems(itemName = "Humidity", itemValue =it.currentConditions.humidity!!.roundToInt(),unit=" %")
                        RowItems(itemName = "Dew Point", itemValue =it.currentConditions.dew!!.roundToInt(),unit=" °C")
                        RowItems(itemName = "Wind", itemValue =it.currentConditions.windspeed!!.roundToInt(),unit=" km/h")
                        RowItems(itemName = "Pressure", itemValue =it.currentConditions.pressure!!.roundToInt(), unit = "mb")
                        RowItems(itemName = "UV Index", itemValue =it.currentConditions.uvindex!!.roundToInt(),unit=" LOW")
                        RowItemsString(itemName = "Sunrise", itemValue =it.currentConditions.sunrise!!)
                        RowItemsString(itemName = "Sunset", itemValue =it.currentConditions.sunrise!!)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = it.description)
                    }

                }


            }
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center)) 
        }
        if(state.error.isNotBlank()){
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
    }
}