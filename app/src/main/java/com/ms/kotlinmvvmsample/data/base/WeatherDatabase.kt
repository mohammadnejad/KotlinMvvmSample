package com.ms.kotlinmvvmsample.data.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import com.ms.kotlinmvvmsample.data.source.local.WeatherDao

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/6/18
 */

@Database(entities = [(LocalWeather::class)], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        private var INSTANCE: WeatherDatabase? = null

        fun getInstance(context: Context): WeatherDatabase? {
            if (INSTANCE == null) {
                synchronized(WeatherDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            WeatherDatabase::class.java,
                            "weather.db"
                    ).build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}