package com.endiel.weatherapp.weather_forecast_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    // with "get(0)" we get the current hour weather
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            CurrentDetailsDisplay(state = state)
            Spacer(modifier = Modifier.height(4.dp))
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    LazyRow(content = {
                        items(data) { weatherData ->
                            HourlyWeatherDisplay(
                                weatherData = weatherData,
                                modifier = Modifier
                                    .height(112.dp)
                            )
                        }
                    })
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}