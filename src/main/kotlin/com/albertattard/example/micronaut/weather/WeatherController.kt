package com.albertattard.example.micronaut.weather

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/weather")
class WeatherController internal constructor(
    private var service: WeatherService
) {

    @Get("/forecast", produces = [MediaType.APPLICATION_JSON])
    fun forecast(): Forecast {
        return service.latestForecast()
    }
}
