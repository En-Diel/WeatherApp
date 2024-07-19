package com.endiel.weatherapp.weather_forecast_feature.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.endiel.weatherapp.weather_forecast_feature.data.remote.WeatherDataDto
import com.endiel.weatherapp.weather_forecast_feature.data.remote.WeatherDto
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherData
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherInfo
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)
// WeatherDataDto to Weather Data Map
@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val humidity = humidities[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val weatherCode = weatherCodes[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                humidity = humidity,
                windSpeed = windSpeed,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24 // Up to here we have Int to index map (But that's not what we want,so we map it again values)
    }.mapValues {
        it.value.map { it.data }
    }
}
// This maps the WeatherDto to the WeatherInfo
@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}