package io.instacode.university.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "university.db")
public class UniversityDatabaseProperties {

    private String entity;
    private String driver;
    private String url;
    private String username;
    private String password;

}
