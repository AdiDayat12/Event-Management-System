package com.practice.event_management_system.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Slf4j
public class ConnectionUtil {
    private static  Properties properties = new Properties();
    private static boolean isLoaded = false;
    static {
        try (InputStream input = ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")){
            if (input == null){
                log.error("Cannot load properties");
            } else {
                properties.load(input);
                isLoaded = true;
            }

        } catch (IOException e) {
            log.error("Error loading properties : {}", e.getMessage());
        }
    }

    private static final HikariDataSource dataSource;

    static {
        if (isLoaded){
            HikariConfig config = new HikariConfig();

            config.setDriverClassName("driver");
            config.setJdbcUrl(properties.getProperty("url"));
            config.setUsername(properties.getProperty("username"));
            config.setPassword(properties.getProperty("pass"));

            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setMaxLifetime(60_000 * 10);
            config.setConnectionTimeout(60_000 * 10);

            dataSource = new HikariDataSource(config);
        } else {
            dataSource = null;
        }

    }

    public HikariDataSource getDataSource (){
        if (dataSource == null){
            log.error("DataSource not initialized due to error in loading properties.");
        }
        return dataSource;
    }

}
