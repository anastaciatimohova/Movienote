package com.movienote.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {


    private String url;
    private String username;
    private String password;
    private String driverClassName;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        System.out.println("DB connection to DEV ");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to DEV ";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB Connection  to TEST ");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection  to TEST ";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        System.out.println("DB Connection to PROD ");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to PROD ";
    }
}
