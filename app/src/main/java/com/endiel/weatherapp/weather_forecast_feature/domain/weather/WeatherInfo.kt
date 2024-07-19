package com.endiel.weatherapp.weather_forecast_feature.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
