package com.endiel.weatherapp.weather_forecast_feature.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,pressure_msl," +
            "wind_speed_10m,weather_code,relative_humidity_2m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto // It retuns the weather dto from the api
}