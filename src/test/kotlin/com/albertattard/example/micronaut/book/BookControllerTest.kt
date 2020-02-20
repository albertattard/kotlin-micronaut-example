package com.albertattard.example.micronaut.book

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

@MicronautTest
class BookControllerTest(
    private val service: BookService,
    @Client("/book") private val client: RxHttpClient
) : StringSpec({
    "should return the book provided by the book service" {
        val mock = getMock(service)

        val bookOfTheDay = Book("Hello Micronaut World")
        every { mock.bookOfTheDay() } returns bookOfTheDay

        val result = client.toBlocking().retrieve("/", Book::class.java)
        result shouldBe bookOfTheDay

        verify(exactly = 1) { mock.bookOfTheDay() }

        /* TODO: check why this needs to be verified */
        verify(exactly = 2) { mock.hashCode() }
        verify(exactly = 1) { mock.toString() }
        confirmVerified(mock)
    }
}) {
    @MockBean(BookService::class)
    fun bookService(): BookService {
        return mockk()
    }
}
