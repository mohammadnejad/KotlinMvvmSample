package com.ms.kotlinmvvmsample.data.source

import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherRepository(
        private val weatherRemoteDataSource: WeatherDataSource,
        private val weatherLocalDataSource: WeatherDataSource
) : WeatherDataSource {

    override fun insertCurrentWeather(localWeather: LocalWeather) {
        weatherLocalDataSource.insertCurrentWeather(localWeather)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        weatherRemoteDataSource.getCurrentWeatherByCityName(cityName)
                ?.doAfterSuccess {
                    insertCurrentWeather(it)
                }

        return weatherLocalDataSource.getCurrentWeatherByCityName(cityName)

    }

    companion object {
        private var INSTANCE: WeatherRepository? = null

        @JvmStatic
        fun getInstance(weatherRemoteDataSource: WeatherDataSource,
                        weatherLocalDataSource: WeatherDataSource) =
                INSTANCE ?: synchronized(WeatherDataSource::class.java) {
                    INSTANCE ?: WeatherRepository(weatherRemoteDataSource, weatherLocalDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}