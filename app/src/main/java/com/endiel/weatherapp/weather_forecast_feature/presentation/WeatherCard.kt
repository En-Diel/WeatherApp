package com.endiel.weatherapp.weather_forecast_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            //shape = RoundedCornerShape(48.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f),
                //horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = data.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(32.dp)
                        .align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.align(alignment = Alignment.End)) {
                    Text(
                        text = "${data.temperatureCelsius}ºC",
                        fontSize = 80.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.align(alignment = Alignment.End)
                    )
                    Text(
                        text = data.weatherType.weatherDesc,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                WeatherForecastDisplay(state = state)
            }
        }
    }
}