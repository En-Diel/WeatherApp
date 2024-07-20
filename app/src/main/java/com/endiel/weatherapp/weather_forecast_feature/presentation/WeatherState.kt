package com.endiel.weatherapp.weather_forecast_feature.presentation

import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
