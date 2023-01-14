package nishant.lab.weatherapplication.data.remote.data_transfare_object

data class Hour(
    val cloudcover: Double?=null,
    val conditions: String?=null,
    val datetime: String?=null,
    val datetimeEpoch: Int?=null,
    val dew: Double?=null,
    val feelslike: Double?=null,
    val humidity: Double?=null,
    val icon: String?=null,
    val precip: Double?=null,
    val precipprob: Double?=null,
    val preciptype: List<String>?=null,
    val pressure: Double?=null,
    val severerisk: Double?=null,
    val snow: Double?=null,
    val snowdepth: Double?=null,
    val solarenergy: Double? = null,
    val solarradiation: Double?=null,
    val source: String?=null,
    val stations: List<String>?=null,
    val temp: Double?=null,
    val uvindex: Double?=null,
    val visibility: Double?=null,
    val winddir: Double?=null,
    val windgust: Double?=null,
    val windspeed: Double?=null
)