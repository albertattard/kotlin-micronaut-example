plugins {
    application
    kotlin("jvm").version("1.3.61")
    kotlin("kapt").version("1.3.61")
    kotlin("plugin.allopen").version("1.3.61")

    id("com.github.johnrengelman.shadow").version("5.2.0")
    id("org.jlleitschuh.gradle.ktlint").version("9.1.1")
    id("com.github.ben-manes.versions").version("0.27.0")
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    val micronautVersion = "1.3.0"
    val kotlinVersion = "1.3.61"

    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    // implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-http-client")
    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kaptTest("io.micronaut:micronaut-inject-java")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))

    testImplementation("io.micronaut.test:micronaut-test-kotlintest:1.1.2")
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.0")

    implementation("org.jetbrains.exposed:exposed:0.17.7")
    implementation("com.h2database:h2:1.4.200")
}

configurations {
    all {
        resolutionStrategy {
            force(
                "com.pinterest:ktlint:0.36.0",
                "com.pinterest.ktlint:ktlint-reporter-checkstyle:0.36.0"
            )
        }
    }
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

defaultTasks("clean", "ktlintFormat", "dependencyUpdates", "test")
