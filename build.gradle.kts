val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.dipien:semantic-version-gradle-plugin:1.3.1")
    }
}

plugins {
    application
    kotlin("jvm") version "1.7.21"
    id("io.ktor.plugin") version "2.1.3"
    id("com.dipien.semantic-version") version "1.3.1" apply false
}

group = "be.florentgit"
version = "0.0.1"
apply<com.semanticversion.gradle.plugin.SemanticVersionGradlePlugin>()

application {
    mainClass.set("be.florentgit.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}