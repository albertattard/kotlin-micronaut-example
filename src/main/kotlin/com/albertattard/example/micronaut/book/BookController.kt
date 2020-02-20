package com.albertattard.example.micronaut.book

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/book")
class BookController internal constructor(
    private var service: BookService
) {

    @Get("/", produces = [MediaType.APPLICATION_JSON])
    fun index(): Book {
        return service.bookOfTheDay()
    }
}
