plugins {
    application
    checkstyle
    jacoco
    java

    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    id("io.freefair.lombok") version "8.6"
    id("com.adarshr.test-logger") version "4.0.0"
    id("io.sentry.jvm.gradle") version "4.3.1"
    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

application { mainClass.set("hexlet.code.AppApplication") }

buildscript {
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.9"
    reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    // Spring Boot Starter Dependencies
    implementation("org.springframework.boot:spring-boot-starter:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")
    developmentOnly("org.springframework.boot:spring-boot-devtools:3.2.3")

    // Spring Data Dependencies
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.3")

    // Spring Security and OAuth2 Resource Server
    implementation("org.springframework.boot:spring-boot-starter-security:3.2.3")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.2.3")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:3.2.3")

    // MapStruct
    implementation("org.mapstruct:mapstruct:1.6.0.Beta1")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.0.Beta1")

    // OpenAPI Tools
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // Database Dependencies
    runtimeOnly("com.h2database:h2:2.2.224")
    runtimeOnly("org.postgresql:postgresql:42.7.2")

    // Test Dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.3")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.1")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.3")
    testImplementation("org.springframework.security:spring-security-test:6.2.2")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:3.2.7")
    implementation("net.datafaker:datafaker:2.1.0")
    implementation("org.instancio:instancio-junit:4.3.2")
    testCompileOnly("org.projectlombok:lombok:1.18.22")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.22")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.3.3"
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}

tasks.withType<Test> {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

val env = System.getenv("APP_ENV")
sentry {
    if (env != null && env.contentEquals("prod")) {
        includeSourceContext = true
        org = "noname-ab"
        projectName = "java-spring-boot"
        authToken = System.getenv("SENTRY_AUTH_TOKEN")
    }
}
