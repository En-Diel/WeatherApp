package com.endiel.weatherapp.weather_forecast_feature.di

import com.endiel.weatherapp.weather_forecast_feature.data.location.DefaultLocationTracker
import com.endiel.weatherapp.weather_forecast_feature.domain.location.LocationTracker
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}