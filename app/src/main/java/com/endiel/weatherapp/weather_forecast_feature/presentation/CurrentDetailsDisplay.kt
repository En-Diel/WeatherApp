package com.endiel.weatherapp.weather_forecast_feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.endiel.weatherapp.R

@Composable
fun CurrentDetailsDisplay(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Row(modifier = Modifier) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDataDisplay(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                    dataType = "Wind",
                    value = data.windSpeed.toInt(),
                    unit = " Km/h"
                )
                WeatherDataDisplay(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                    dataType = "Pressure",
                    value = data.pressure.toInt(),
                    unit = " hPa"
                )
                WeatherDataDisplay(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                    dataType = "Humidity",
                    value = data.humidity.toInt(),
                    unit = "%"
                )
            }
        }
    }
}