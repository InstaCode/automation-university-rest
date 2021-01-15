package io.instacode.university;

import io.instacode.university.configuration.UniversityConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(UniversityConfigProperties.class)
@ComponentScan(basePackages = {"io.instacode.university.*"})
public class WebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServicesApplication.class);
    }
}
