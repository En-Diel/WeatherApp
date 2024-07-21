package com.endiel.weatherapp.weather_forecast_feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherDataDisplay(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    dataType: String,
    value: Int,
    unit: String,
    iconTint: Color = MaterialTheme.colorScheme.surfaceTint,
    textStyle: TextStyle = TextStyle()
) {
   Row(
       modifier = Modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween
   ) {
       Column(
           modifier = modifier,
           verticalArrangement = Arrangement.Center
       ) {
           Icon(
               imageVector = icon,
               tint = iconTint,
               contentDescription = null,
               modifier = Modifier.size(16.dp)
           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = dataType,
               fontSize = 10.sp,
               style = textStyle
           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = "$value$unit",
               fontSize = 10.sp,
               style = textStyle
           )
       }
   }
}

/*
@Preview(showBackground = true)
@Composable
fun WeatherDataPreview() {
    WeatherAppTheme {
        WeatherData(icon = ImageVector)
    }
}

 */