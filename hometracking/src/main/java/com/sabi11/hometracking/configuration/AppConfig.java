package com.sabi11.hometracking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration // Tell to Spring this is configuration file
@PropertySource("classpath:db.properties") // Tell to Spring which properties file and location
@EnableTransactionManagement // enable the transaction
@ComponentScans(value={ // Tell to Spring which packages need to be scanned
        @ComponentScan("com.sabi11.hometracking.dao"),
        @ComponentScan("com.sabi11.hometracking.service")
})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = new Properties();

        //Setting JDBC properties
        props.put(
                DRIVER,
                environment.getProperty("mysql.drive"));
        props.put(
                URL,
                environment.getProperty("mysql.url"));
        props.put(
                USER,
                environment.getProperty("mysql.user"));
        props.put(
                PASS,
                environment.getProperty("mysql.password"));

        //Setting hibernate properties
        props.put(
                SHOW_SQL,
                environment.getProperty("hibernate.show_sql"));
        props.put(
                HBM2DDL_AUTO,
                environment.getProperty("hibernate.hbm2ddl.auto"));

        //Setting connection pool properties
        props.put(
                C3P0_MIN_SIZE,
                environment.getProperty("hibernate.c3p0.min_size"));
        props.put(
                C3P0_MAX_SIZE,
                environment.getProperty("hibernate.c3p0.MAX_size"));
        props.put(
                C3P0_ACQUIRE_INCREMENT,
                environment.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(
                C3P0_TIMEOUT,
                environment.getProperty("hibernate.c3p0.timeout"));
        props.put(
                C3P0_MAX_STATEMENTS,
                environment.getProperty("hibernate.c3p0.max_statements"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.sab11.hometracking.model");

        return factoryBean;
    }

    public HibernateTransactionManager getTransactionManager() {

        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(
                getSessionFactory().getObject());

        return transactionManager;

    }

}
