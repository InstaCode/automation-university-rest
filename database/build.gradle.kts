plugins {
    idea
    java
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("io.freefair.lombok") version "5.3.0"
    id("org.sonarqube") version "3.0"
    jacoco
}


sonarqube {
    properties {
        property("sonar.projectKey", "InstaCode_automation-university")
        property("sonar.organization", "instacode")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.16")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.4.1")
    implementation("org.apache.tomcat:tomcat-dbcp:10.0.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.1")
    implementation("org.hibernate:hibernate-core:5.4.27.Final")
    implementation("mysql:mysql-connector-java:8.0.22")
    implementation("com.h2database:h2:1.4.200")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.springframework:spring-orm:5.3.2")
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}





