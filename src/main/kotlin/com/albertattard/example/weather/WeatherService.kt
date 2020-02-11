package com.albertattard.example.weather

import io.micronaut.runtime.context.scope.Refreshable
import java.text.SimpleDateFormat
import java.util.Date
import javax.annotation.PostConstruct

@Refreshable
class WeatherService {
    private var forecast: Forecast = Forecast("Unknown")

    @PostConstruct
    fun init() {
        forecast = Forecast("Scattered Clouds " + SimpleDateFormat("dd/MMM/yyyy HH:mm:ss.SSS").format(Date()))
    }

    fun latestForecast(): Forecast {
        return forecast
    }
}
