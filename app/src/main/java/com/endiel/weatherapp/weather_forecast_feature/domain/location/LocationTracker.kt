package com.endiel.weatherapp.weather_forecast_feature.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}