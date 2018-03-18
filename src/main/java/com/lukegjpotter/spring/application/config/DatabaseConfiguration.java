package com.lukegjpotter.spring.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() throws URISyntaxException {

        URI dbUri = new URI(environment.getProperty("DATABASE_URL", "postgres://postgres:@localhost:5432/cyclingirelandevents"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password;
        try {
            password = dbUri.getUserInfo().split(":")[1];
        } catch (ArrayIndexOutOfBoundsException ignored) {
            password = "";
        }
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
