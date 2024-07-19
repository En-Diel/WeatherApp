package com.endiel.weatherapp.weather_forecast_feature.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @field:Json(name = "pressure_msl")
    val pressures: List<Double>,
    @field:Json(name = "wind_speed_10m")
    val windSpeeds: List<Double>,
    @field:Json(name = "relative_humidity_2m")
    val humidities: List<Double>,
    @field:Json(name = "weather_code")
    val weatherCodes: List<Int>
)
