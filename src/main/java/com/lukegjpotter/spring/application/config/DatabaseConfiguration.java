package com.lukegjpotter.spring.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() throws URISyntaxException {

        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        String driverClassName = "org.postgresql.Driver";

        return DataSourceBuilder
                .create()
                .url(dbUrl)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }
}
