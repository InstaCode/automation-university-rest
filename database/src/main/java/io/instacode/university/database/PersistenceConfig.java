package io.instacode.university.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "io.instacode.university.database")
public class PersistenceConfig {


//  @Bean(name="entityManagerFactory")
//  public LocalSessionFactoryBean sessionFactory() {
//    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//    sessionFactory.setDataSource(dataSource());
//    sessionFactory.setPackagesToScan("io.instacode.university.database");
//    sessionFactory.setHibernateProperties(hibernateProperties());
//    return sessionFactory;
//  }
//
//  private final Properties hibernateProperties() {
//    Properties hibernateProperties = new Properties();
//    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//    hibernateProperties.setProperty("spring.jpa.show-sql", String.valueOf(true));
//    hibernateProperties.setProperty("spring.jpa.generate-ddl", String.valueOf(true));
//    return hibernateProperties;
//  }
//
//  @Bean
//  public DataSource dataSource() {
//
//    BasicDataSource dataSource = new BasicDataSource();
//    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    dataSource.setUrl("jdbc:mysql://docker:33060/university_db?serverTimezone=CST&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true");
//    dataSource.setUsername("root");
//    dataSource.setPassword("password");
//    return dataSource;
//  }
//
//  @Bean
//  public PlatformTransactionManager hibernateTransactionManager() {
//    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//    transactionManager.setSessionFactory(sessionFactory().getObject());
//    return transactionManager;
//  }
}
