package com.endiel.weatherapp.weather_forecast_feature.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Orange80,
    onPrimary = Orange20,
    primaryContainer = Orange30,
    inversePrimary = Orange40,
    secondary = DarkOrange80,
    onSecondary = DarkOrange20,
    secondaryContainer = DarkOrange30,
    onSecondaryContainer = DarkOrange90,
    tertiary = Gold80,
    onTertiary = Gold20,
    tertiaryContainer = Gold30,
    onTertiaryContainer = Gold90,
    error = Red80,
    onError = Red20,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey30,
    onBackground = Grey90,
    surface = OrangeGrey30,
    onSurface = OrangeGrey80,
    inverseSurface = OrangeGrey90,
    inverseOnSurface = Grey30,
    surfaceVariant = OrangeGrey30,
    onSurfaceVariant = OrangeGrey80,
    outline = OrangeGrey80
)

private val LightColorScheme = lightColorScheme(
    primary = Orange40,
    onPrimary = Color.White,
    primaryContainer = Orange10,
    inversePrimary = Orange80,
    secondary = DarkOrange40,
    onSecondary = Color.White,
    secondaryContainer = DarkOrange90,
    onSecondaryContainer = DarkOrange10,
    tertiary = Gold40,
    onTertiary = Color.White,
    tertiaryContainer = Gold90,
    onTertiaryContainer = Gold10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey90,
    onBackground = Grey30,
    surface = OrangeGrey90,
    onSurface = OrangeGrey30,
    inverseSurface = Grey30,
    inverseOnSurface = Grey90,
    surfaceVariant = OrangeGrey90,
    onSurfaceVariant = OrangeGrey30,
    outline = OrangeGrey50
)

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}