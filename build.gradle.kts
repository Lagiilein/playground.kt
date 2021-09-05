plugins {
    base
    java
    kotlin("jvm") version "1.5.30"
    id("io.gitlab.arturbosch.detekt") version "1.18.1"
}

val javaVersion = JavaVersion.VERSION_16

repositories {
    mavenCentral()
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        this.jvmTarget = javaVersion.toString()
        this.freeCompilerArgs = listOf("-Xjsr305=strict", "-Xopt-in=kotlin.RequiresOptIn")
    }
}

detekt {
    autoCorrect = true
    buildUponDefaultConfig = true

    config = files("${rootDir}/detekt.yml")
    parallel = true
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
    }
}

java {
    toolchain {
        this.languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
    }
}

tasks.named("check") {
    dependsOn(tasks.withType<io.gitlab.arturbosch.detekt.Detekt>())
}
