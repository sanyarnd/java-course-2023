import org.gradle.internal.impldep.org.bouncycastle.util.encoders.UTF8

plugins {
    id("java")
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.github.davidmc24.gradle.plugin.avro") version "1.5.0"
}

repositories {
    mavenCentral()
    maven("https://packages.confluent.io/maven/")
}

avro {
    setCreateSetters(false)
    setOutputCharacterEncoding(Charsets.UTF_8)
}

tasks {
    generateAvroJava {
        source("${projectDir}/src/main/resources/avro")
        setOutputDir(file("${projectDir}/src/main/java"))
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.0")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    // EUREKA CLIENT
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:42.5.4")
    implementation("org.liquibase:liquibase-core")

    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.apache.avro:avro:1.11.3")
    implementation("io.confluent:kafka-avro-serializer:7.3.0")

    implementation("org.springframework.boot:spring-boot-starter-validation")

    compileOnly("org.projectlombok:lombok")
    compileOnly("org.mapstruct:mapstruct:1.5.3.Final")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}