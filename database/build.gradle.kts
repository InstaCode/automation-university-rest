plugins {
    idea
    java
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("io.freefair.lombok") version "5.3.0"
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    //runtimeOnly("com.h2database:h2")
    implementation("org.projectlombok:lombok:1.18.16")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.4.1")
    implementation("org.apache.tomcat:tomcat-dbcp:9.0.1")
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.1")
    implementation("org.hibernate:hibernate-entitymanager:5.4.25.Final")
    implementation("mysql:mysql-connector-java:8.0.22")
    implementation ("com.github.javafaker:javafaker:1.0.2")
    implementation ("org.springframework:spring-orm:5.1.3.RELEASE")
}



