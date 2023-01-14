package nishant.lab.weatherapplication.comman.util

import android.content.Context
import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun getDrawable(name: String?, c: Context): Int {
    val resources: Resources = c.getResources()
    val v = resources.getIdentifier(name, "drawable", c.getPackageName())
    return v
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateConverter(date : String) : String {
    val dateTime = SimpleDateFormat("yyyy-MM-dd")
    val date : Date = dateTime.parse(date)
    val stf =  SimpleDateFormat("EEEE,dd,MMMM")
    return stf.format(date)
}

@RequiresApi(Build.VERSION_CODES.O)
fun timeConverter(time:String):String{
    val time = ZonedDateTime.parse(time)
    return time.withZoneSameInstant(ZoneId.of("UTC-02")).format(DateTimeFormatter.ofPattern(" hh:mm a"))
}

fun convertFahrenheitToCelsius(double: Double):Double{
    return (((double-32)*5)/9)
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateConverterByDays(date : String) : String {
    val dateTime = SimpleDateFormat("yyyy-MM-dd")
    val date : Date = dateTime.parse(date)
    val stf =  SimpleDateFormat("EEE,dd")
    return stf.format(date)
}