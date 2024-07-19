package com.endiel.weatherapp.weather_forecast_feature.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    // Hourly weather data
    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)
