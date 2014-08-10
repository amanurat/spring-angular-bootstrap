package com.thysmichels.config;

import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * Created by tmichels on 8/9/14.
 */

@Configuration
public interface DataSourceConfig {
    DataSource dataSource();
}