package com.albertattard.example.micronaut.book

import io.micronaut.context.annotation.Primary
import javax.inject.Singleton

@Primary
@Singleton
class PrimaryBookService : BookService {

    override fun bookOfTheDay() =
        Book("The Micronaout Framework")
}
