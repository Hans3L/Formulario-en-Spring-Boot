package com.creativity.registrymicroservice.configuration;

import com.creativity.registrymicroservice.util.MicroserviceException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.creativity.registrymicroservice.repository"})
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class,
        DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableTransactionManagement
public class DatabaseConfig {

    Logger LOGGER = LogManager.getLogger(DatabaseConfig.class);

    @Value("${jdbc.password}")
    private String dbPassword;

    @Value("${jdbc.username}")
    private String dbUsername;

    @Value("${jdbc.url}")
    private String dbUrl;

    @Value("${db.connection.timeout}")
    private int connectionTimeout;

    @Value("${db.connection.idle.timeout}")
    private int idleTimeout;

    @Value("${db.connection.max.lifetime}")
    private int maxLifetime;

    @Value("${db.initialization.fail.timeout}")
    private int initializationFailTimeout;

    @Value("${db.maximum.pool.size}")
    private int maximumPoolSize;

    @Value("${db.connection.minimum.idle}")
    private int minimumIdle;

    @Value("${db.connection.validation.timeout}")
    private int validationTimeout;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.cache}")
    private String hibernateCache;

    @Value("${hibernate.query.cache}")
    private String hibernateQueryCache;

    @Value("${hibernate.jdbc.batch_size}")
    private String batchSize;

    @Value("${org.hibernate.flushMode}")
    private String flushMode;

    @Value("${hibernate.enable_lazy_load_no_trans}")
    private String enableLazyLoadNoTrans;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.jdbc.fetch_size}")
    private String hibernateJdbcFetchSize;

    @Value("${hibernate.max_fetch_depth}")
    private String hibernateMaxFetchDepth;

    @Value("${hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Value("${hibernate.naming.physical-strategy}")
    private String hibernateNamingPhysicalStrategy;

    @Bean(name = "dataSource")
    public DataSource dataSource() throws MicroserviceException {
        HikariConfig config = new HikariConfig();
        try {
            config.setUsername(dbUsername);
            config.setPassword(dbPassword);
            config.setJdbcUrl(dbUrl);
            config.setConnectionTimeout(connectionTimeout);
            config.setIdleTimeout(idleTimeout);
            config.setMaxLifetime(maxLifetime);
            config.setMinimumIdle(minimumIdle);
            config.setInitializationFailTimeout(initializationFailTimeout);
            config.setMaximumPoolSize(maximumPoolSize);
            config.setValidationTimeout(validationTimeout);
            return hikariDataSource(new HikariDataSource(config));
        } catch (Exception e) {
            LOGGER.error("Ocurrio un error al insertar parámetro de configuración de Hikari !!!" + e.getMessage());
            throw new MicroserviceException("Ocurrió un error al insertar los parámetros de configuración de Hikari: "
                    + e.getMessage());
        }
    }

    public HikariDataSource hikariDataSource(HikariDataSource ds) throws MicroserviceException {
        try {
            ds.setLoginTimeout(3);
            return ds;
        } catch (Exception e) {
            LOGGER
                    .error("Ocurrió un error al configurar el datasource de Hikari: " + e.getMessage(), e);
            ds.close();
            throw new MicroserviceException(
                    "Ocurrió un error al configurar el datasource de Hikari: " + e.getMessage());
        }
    }

    Properties jpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql",showSql);
        properties.setProperty("hibernate.cache",hibernateCache);
        properties.setProperty("hibernate.jdbc.batch_size",batchSize);
        properties.setProperty("org.hibernate.flushMode",flushMode);
        properties.setProperty("hibernate.enable_lazy_load_no_trans",enableLazyLoadNoTrans);
        properties.setProperty("hibernate.dialect",hibernateDialect);
        properties.setProperty("hibernate.query.cache", hibernateQueryCache);
        properties.setProperty("hibernate.jdbc.fetch_size",hibernateJdbcFetchSize);
        properties.setProperty("hibernate.max_fetch_depth.",hibernateMaxFetchDepth);
        properties.setProperty("hibernate.ddl-auto",hibernateDdlAuto);
        properties.setProperty("hibernate.naming.physical-strategy",hibernateNamingPhysicalStrategy);
    return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws MicroserviceException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[]{"com.creativity.registrymicroservice.entity"});
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}
