# An example of the Micronaut Framework and Kotlin

## Pending Issues

1. Latest version of `kotlintest-runner-junit5` fails with an `initializationError`

    ```kotlin
    dependencies {
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    }
    ```

    Had to revert to a previous version, `3.4.0` until this is sorted.  The issue seems to be related to JUnit 5 and some swallowed exception.  It seems that some types are missing from the classpath.  Further investigation is required.
