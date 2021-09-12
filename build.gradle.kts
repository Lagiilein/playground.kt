import Build_gradle.Constants.GITHUB_REPO_NAME
import Build_gradle.Constants.GITHUB_REPO_OWNER
import Build_gradle.Constants.REPOSITORY_URL

plugins {
    base
    java
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.5.30"
    id("io.gitlab.arturbosch.detekt") version "1.18.1"
    id("com.gorylenko.gradle-git-properties") version "2.3.1" apply false
}

group = "play"
version = "0.1.5"

object Constants {
    const val GITHUB_REPO_OWNER = "Lagiilein"
    const val GITHUB_REPO_NAME = "playground.kt"
    const val REPOSITORY_URL = "https://github.com/${GITHUB_REPO_OWNER}/${GITHUB_REPO_NAME}"
}

subprojects {

    version = rootProject.version
    group = rootProject.group

    apply {
        plugin("java")
        plugin("kotlin")
        plugin("java-library")
        plugin("maven-publish")
        plugin("io.gitlab.arturbosch.detekt")
        plugin("com.gorylenko.gradle-git-properties")
    }

    val javaVersion = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    dependencies {
        api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.5.2"))

        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.1")

        testImplementation(kotlin("test"))
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
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(javaVersion.majorVersion))
        }
    }

    java {
        withSourcesJar()
    }

    configure<PublishingExtension> {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/Lagiilein/playground.kt")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
            // docker run -d -p 8081:8081 --name nexus sonatype/nexus3
//            maven {
//                name = "local-nexus"
//                url = uri("http://localhost:8081/repository/maven-releases/")
//                isAllowInsecureProtocol = true
//                credentials {
//                    username = "admin"
//                    password = "poop"
//                }
//            }
        }
        publications {
            register<MavenPublication>("idk") {

                versionMapping {
                    usage("java-api") {
                        fromResolutionOf("runtimeClasspath")
                    }
                    usage("java-runtime") {
                        fromResolutionResult()
                    }
                }

                pom {
                    name.set("${this@subprojects.group}:${this@subprojects.name}")
                    description.set(name.get())
                    url.set(REPOSITORY_URL)

                    issueManagement {
                        this.url.set("$REPOSITORY_URL/issues")
                    }

                    licenses {
                        license {
                            name.set("MIT")
                            url.set("https://raw.githubusercontent.com/${GITHUB_REPO_OWNER}/${GITHUB_REPO_NAME}/master/LICENSE")
                        }
                    }

                    scm {
                        connection.set("scm:git:${REPOSITORY_URL}")
                        developerConnection.set(connection.get())
                        url.set(REPOSITORY_URL)
                    }
                }

                from(components["java"])
            }
        }
    }
}

tasks.named("check") {
    dependsOn(tasks.withType<io.gitlab.arturbosch.detekt.Detekt>())
}
