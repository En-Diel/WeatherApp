package com.endiel.weatherapp.weather_forecast_feature.domain.util

// This class will provide Successa and Error messages whenever we call it
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String?, data: T? = null): Resource<T>(data, message)
}