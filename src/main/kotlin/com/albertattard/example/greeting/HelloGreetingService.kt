package com.albertattard.example.greeting

import javax.inject.Singleton

@Singleton
class HelloGreetingService : GreetingService {

    override fun greet() =
        Greeting("Hello World")
}
