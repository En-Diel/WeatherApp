package com.endiel.weatherapp.weather_forecast_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.endiel.weatherapp.weather_forecast_feature.domain.weather.WeatherData
import com.endiel.weatherapp.weather_forecast_feature.presentation.ui.theme.WeatherAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    state: WeatherState
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data -> // with "get(0)" we get the current hour weather
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.Center
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
    }
}

/*
@Preview(showBackground = true)
@Composable
fun WeatherDataPreview() {
    WeatherAppTheme {
        WeatherDataDisplay(icon = ImageVector(), dataType = String(), value = Int(), unit = String())
    }
}

 */