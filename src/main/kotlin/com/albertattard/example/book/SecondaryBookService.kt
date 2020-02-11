package com.albertattard.example.book

import javax.inject.Singleton

@Singleton
@FallbackBookService
class SecondaryBookService : BookService {

    override fun bookOfTheDay() =
        Book("Hello Simple World")
}
