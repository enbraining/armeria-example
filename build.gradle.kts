plugins {
    kotlin("jvm") version "1.9.21"
    java
    idea
    eclipse
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    listOf(
        "armeria",
        "armeria-brave",
        "armeria-grpc",
        "armeria-jetty9",
        "armeria-kafka",
        "armeria-logback",
        "armeria-retrofit2",
        "armeria-rxjava3",
        "armeria-saml",
        "armeria-thrift0.13",
        "armeria-tomcat9",
        "armeria-zookeeper3").forEach {
        implementation("com.linecorp.armeria:${it}:1.26.4")
    }

    // Logging
    runtimeOnly("ch.qos.logback:logback-classic:1.4.11")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}