package com.albertattard.example.book

import io.micronaut.context.annotation.Primary
import javax.inject.Singleton

@Primary
@Singleton
class PrimaryBookService : BookService {

    override fun bookOfTheDay() =
        Book("The Micronaout Framework")
}
