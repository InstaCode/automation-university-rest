package io.instacode.university.database;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setConfigLocation(config);
        localSessionFactoryBean.setPackagesToScan(environment.getProperty("university.db.entity.package"));
        localSessionFactoryBean.setDataSource(dataSource());
        return localSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("university.db.driver"));
        dataSource.setUrl(environment.getProperty("university.db.url"));
        dataSource.setUsername(environment.getProperty("university.db.username"));
        dataSource.setPassword(environment.getProperty("university.db.password"));
        return dataSource;
    }
}
