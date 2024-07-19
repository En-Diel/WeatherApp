package com.endiel.weatherapp.weather_forecast_feature.domain.repository

import com.endiel.weatherapp.weather_forecast_feature.domain.util.Resource
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}