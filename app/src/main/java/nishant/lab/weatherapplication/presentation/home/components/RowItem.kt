package nishant.lab.weatherapplication.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowItems(
    itemName : String,
    itemValue:Int,
    unit: String
){
    Divider()
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = itemName)
        Text(text = "$itemValue$unit")
    }

}

@Composable
fun RowItemsString(
    itemName : String,
    itemValue:String
){
    Divider()
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = itemName)
        Text(text = itemValue)
    }

}