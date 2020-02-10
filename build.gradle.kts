plugins {
    application
    kotlin("jvm").version("1.3.61")
    kotlin("kapt").version("1.3.61")
    kotlin("plugin.allopen").version("1.3.61")

    id("com.github.johnrengelman.shadow").version("5.2.0")
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    val micronautVersion = "1.2.3"
    val kotlinVersion = "1.3.61"

    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-http-client")
    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kaptTest("io.micronaut:micronaut-inject-java")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))

    testImplementation ("io.micronaut.test:micronaut-test-kotlintest:1.1.2")
    testImplementation ("io.mockk:mockk:1.9.3")
    testImplementation ("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.javaParameters = true
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

application {
    mainClassName = "com.albertattard.example.Application"
}

allOpen {
    annotation("io.micronaut.aop.Around")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        mergeServiceFiles()
    }
}
