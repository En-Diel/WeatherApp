package com.endiel.weatherapp.weather_forecast_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.endiel.weatherapp.R
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    modifier: Modifier = Modifier,
    state: WeatherState,
    //backgroundColor: Color = MaterialTheme.colorScheme.background
    //image: ImageVector
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            modifier = modifier.padding(8.dp).size(540.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(60.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                //horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = data.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = "${data.temperatureCelsius}ºC",
                    fontSize = 100.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.align(alignment = Alignment.End)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.End)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = "City",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(end = 32.dp)
                        .align(Alignment.End)
                )
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
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

/*
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun WeatherCardPreview(modifier: Modifier = Modifier) {
    WeatherAppTheme {
        WeatherCard(state = WeatherState())
    }
}

 */