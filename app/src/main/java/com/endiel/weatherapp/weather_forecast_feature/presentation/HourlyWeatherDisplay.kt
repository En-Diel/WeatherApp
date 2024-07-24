package com.endiel.weatherapp.weather_forecast_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .size(100.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = formattedTime,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${weatherData.temperatureCelsius}º",
            fontSize = 20.sp
        )
    }
}