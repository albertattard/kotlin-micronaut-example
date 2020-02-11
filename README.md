# An example of the Micronaut Framework and Kotlin

## Pending Issues

1. Mocked services `hashCode()` called unexpectedly

    The `confirmVerified(mock)` was failing in the following example
        
    ```kotlin
    val mock = getMock(service)
    
    val greeting = Greeting("Hello Micronaut World")
    every { mock.greet() } returns greeting
    
    val result = client.toBlocking().retrieve("/", Greeting::class.java)
    result shouldBe greeting
    
    verify(exactly = 1) { mock.greet() }
    
    confirmVerified(mock)
    ```

    The `hashCode()` is invoked twice, unexpectedly.  Had to include a `verify` to workaround this issue

    ```kotlin
    verify(exactly = 2) { mock.hashCode() }
    confirmVerified(mock)
    ```

    Need to see why this is happening

1. The '/refersh' endpoint is secured

    Need to un secure this endpoint for now

1. Latest version of `kotlintest-runner-junit5` fails with an `initializationError`

    ```kotlin
    dependencies {
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    }
    ```

    Had to revert to a previous version, `3.4.0` until this is sorted.  The issue seems to be related to JUnit 5 and some swallowed exception.  It seems that some types are missing from the classpath.  Further investigation is required.

1. Need to add custom configurations, such as `developmentOnly`

    ```gradle
    configurations {
        developmentOnly
    }
    dependencies {
        developmentOnly "io.micronaut:micronaut-runtime-osx"
    }
    run.classpath += configurations.developmentOnly
    ```

## Fixed Issues

1. Controller tests are failing in IntelliJ, but work in Gradle

    ```
    io.micronaut.http.client.exceptions.HttpClientResponseException: Page Not Found
    
    	at io.micronaut.http.client.DefaultHttpClient$10.channelRead0(DefaultHttpClient.java:1791)
    	at io.micronaut.http.client.DefaultHttpClient$10.channelRead0(DefaultHttpClient.java:1709)
    	at io.netty.channel.SimpleChannelInboundHandler.channelRead(SimpleChannelInboundHandler.java:99)
    ```

    **Solution**
    
    Make sure that IntelliJ is using gradle to build and run as shown next
    
    ![IntelliJ use gradle to build and run](./docs/images/IntelliJ%20use%20gradle%20to%20build%20and%20run.png "IntelliJ use gradle to build and run")

