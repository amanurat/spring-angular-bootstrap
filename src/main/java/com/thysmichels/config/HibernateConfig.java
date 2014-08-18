package com.thysmichels.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by tmichels on 8/9/14.
 */
@Configuration
@EnableTransactionManagement
@Import({DataSourceConfigImpl.class})
@PropertySource("classpath:/services.properties")
public class HibernateConfig {

    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    public LocalSessionFactoryBean setupSessionFactory(DataSource dataSource) throws Exception {
        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
        localSessionFactory.setDataSource(dataSource);
        localSessionFactory.setPackagesToScan("com.thysmichels.model");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", dialect);
        localSessionFactory.setHibernateProperties(hibernateProperties);
        return localSessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
