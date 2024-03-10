package org.jcz.wiki.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "mytestDataSource")
    @Qualifier("mytestDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mytest")
    public DataSource mytestDataSource() {
        return DataSourceBuilder.create().build();
    }

}