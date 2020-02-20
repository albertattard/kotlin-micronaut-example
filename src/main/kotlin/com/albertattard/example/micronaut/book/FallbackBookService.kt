package com.albertattard.example.micronaut.book

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FallbackBookService
