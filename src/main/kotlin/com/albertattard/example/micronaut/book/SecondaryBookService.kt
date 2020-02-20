package com.albertattard.example.micronaut.book

import javax.inject.Singleton

@Singleton
@FallbackBookService
class SecondaryBookService : BookService {

    override fun bookOfTheDay() =
        Book("Hello Simple World")
}
