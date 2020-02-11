package com.albertattard.example.book

import javax.inject.Singleton

@Singleton
class DefaultBookService : BookService {

    override fun bookOfTheDay() =
        Book("Hello World")
}
