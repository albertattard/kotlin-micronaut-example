package com.albertattard.example

import javax.inject.Singleton

@Singleton
class HelloGreetingService : GreetingService {

    override fun greet() =
            Greeting("Hello World")
}
