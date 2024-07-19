package com.endiel.weatherapp.weather_forecast_feature.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.endiel.weatherapp.weather_forecast_feature.data.mappers.toWeatherInfo
import com.endiel.weatherapp.weather_forecast_feature.data.remote.WeatherApi
import com.endiel.weatherapp.weather_forecast_feature.domain.repository.WeatherRepository
import com.endiel.weatherapp.weather_forecast_feature.domain.util.Resource
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    val api: WeatherApi
): WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}