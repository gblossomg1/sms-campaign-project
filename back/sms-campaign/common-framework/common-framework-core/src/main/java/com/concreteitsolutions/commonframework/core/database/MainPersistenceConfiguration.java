package com.concreteitsolutions.commonframework.core.database;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories({MainPersistenceConfiguration.PACKAGES_TO_SCAN})
public class MainPersistenceConfiguration {

    public static final String PACKAGES_TO_SCAN = "com.concreteitsolutions";

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties hibernateProperties, JpaVendorAdapter hibernateJpaAdapter){

        LOG.debug("Instanciating entity manager factory .. ");
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaProperties(hibernateProperties);
        entityManagerFactory.setJpaVendorAdapter(hibernateJpaAdapter);
        entityManagerFactory.setPackagesToScan(PACKAGES_TO_SCAN);

        return entityManagerFactory;
    }

    @Bean
    public DataSource dataSource(){
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/sms-campaign");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");

        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.format_sql", "true");


        return hibernateProperties;
    }
    @Bean
    public JpaVendorAdapter hibernateJpaAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
