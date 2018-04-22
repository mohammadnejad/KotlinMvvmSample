package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.Weather
import com.ms.kotlinmvvmsample.data.source.WeatherDataSource

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherLocalDataSource : WeatherDataSource {
    override fun getCurrentWeatherByCityName(cityName: String): Weather? {
        return Weather()
    }
}