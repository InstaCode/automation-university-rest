group = "io.instacode.university"
version = "1.0-SNAPSHOT"

plugins {
    //groovy
    idea
    java
    jacoco
    id("edu.umich.med.michr.h2-plugin") version "0.1.1-SNAPSHOT"
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("io.freefair.lombok") version "5.3.0"
    id("org.sonarqube") version "3.0"
    id("org.springframework.cloud.contract") version "3.0.0"
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
    implementation("org.springframework:spring-orm:5.3.13")
    testImplementation("org.assertj:assertj-db:2.0.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:2.4.1")
    implementation("org.springframework.boot:spring-boot-starter-web:2.4.1")
    implementation("org.springframework.boot:spring-boot-starter:2.4.1")
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-extensions:0.0.1")
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-annotations:0.0.1")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    implementation("org.mapstruct:mapstruct-processor:1.4.1.Final")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.4.1")
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    //Cloud Contract

    implementation("org.springframework.cloud:spring-cloud-test-support:3.0.0")
    implementation("org.springframework.cloud:spring-cloud-contract-stub-runner-boot:3.0.0")
    implementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:3.0.0")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-rabbit:3.1.0")
    implementation("io.pivotal.spring.cloud:spring-cloud-services-dependencies:3.1.6.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-dependencies:2020.0.0")
    implementation("org.springframework.cloud:spring-cloud-contract-dependencies:3.0.0")
//    implementation("io.rest-assured:rest-assured:4.3.3")
//    implementation("io.rest-assured:xml-path:4.3.3")
//    implementation("io.rest-assured:json-path:4.3.3")
//    implementation("io.rest-assured:rest-assured-common:4.3.3")
//    implementation("io.rest-assured:rest-assured-all:4.3.3")
//    implementation("com.google.code.gson:gson:2.8.6")
//    implementation ("io.rest-assured:spring-mock-mvc:4.3.3")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.isEnabled = true
    }
}

h2 {
    tcpPassword = "password"
}


sonarqube {
    properties {
        property("sonar.projectKey", "InstaCode_automation-university")
        property("sonar.organization", "instacode")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.junit.reportPaths", "./build/test-results/test")
    }
}

sourceSets {
    contractTest {
        java.sourceDirectories.plus(arrayListOf("src/contractTest/java", "build/generated-contract-test-sources/contracts"))
        resources.sourceDirectories.plus(arrayListOf(file("src/contractTest/resources")))
        compileClasspath += main.get().output + test.get().output
        runtimeClasspath += main.get().output + test.get().output
    }
}

contracts {
    setTestMode("MockMvc")
    setTestFramework("JUNIT5")
    //setNameSuffixForTests("Contract")
    setBaseClassForTests("io.instacode.university.contract.BaseContractTest");
    //packageWithBaseClasses.set("io.instacode.university.contract")
    contractsDslDir.set(file("${project.rootDir}/src/contractTest/resources/contracts"))
    generatedTestJavaSourcesDir.set(file("${project.buildDir}/generated-contract-test-sources/contracts"))
    generatedTestResourcesDir.set(file("${buildDir}/generated-contract-resources/contracts"))
}



task<Test>("runContractTests") {
    useJUnitPlatform()
    description = "Runs contract tests"
    group = "verification"
    testClassesDirs = sourceSets.contractTest.get().output.classesDirs
    classpath = sourceSets.contractTest.get().runtimeClasspath
}

task("deregisterContractTestSources") {
    doLast {
        project.sourceSets.test.get().java {
            project.logger.info("Removing any *Spec classes from the test sources")
            exclude("**/*Contract*")

        }
    }
}

tasks.compileTestJava {
    dependsOn("deregisterContractTestSources")
    doFirst {
        sourceSets.test.configure {
            java.sourceDirectories.minus(file("${project.buildDir}/generated-contract-test-sources/contracts"))
        }
    }
}










