package com.vivacom.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("development")
@Configuration
@PropertySource("classpath:application.properties")
public class DevDatabaseConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataBase = new DriverManagerDataSource();
        dataBase.setUsername(env.getProperty("user"));
        dataBase.setPassword(env.getProperty("password"));
        dataBase.setDriverClassName(env.getProperty("driver"));
        dataBase.setUrl(env.getProperty("url"));
        return dataBase;
    }

}
