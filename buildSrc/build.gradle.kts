plugins {
    java
    kotlin("jvm") version "1.5.31"
}

val javaVersion = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    testApi(kotlin("test"))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        this.jvmTarget = javaVersion.toString()
//        this.languageVersion = "1.4"
        this.freeCompilerArgs = listOf("-Xjsr305=strict", "-Xopt-in=kotlin.RequiresOptIn")
    }
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(javaVersion.majorVersion))
    }
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        showCauses = true
        showExceptions = true
        showStackTraces = true
        showStandardStreams = true
        events("passed", "skipped", "failed")
    }
}
