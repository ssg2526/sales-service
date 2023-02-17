package com.ssg.sales.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@Slf4j
public class PersistenceConfig {

    private static String EM_PACKAGES_TO_SCAN = "com.ssg.*";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
    private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Autowired
    JpaVendorAdapter jpaVendorAdapter;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName = "";
//    @Value("${spring.datasource.url}")
    String url = "jdbc:postgresql://localhost:5432/erp_1?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false";
    @Value("${spring.datasource.username}")
    String userName = "";
    @Value("${spring.datasource.password}")
    String password = "";

    @Bean("tenantEmf")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        log.info("URL++:"+driverClassName);
        entityManagerFactoryBean.setDataSource(DataSourceBuilder.create().url(url).driverClassName(driverClassName)
                .username(userName).password(password).build());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(EM_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setPersistenceUnitName("tenantUnit");
//        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
        return entityManagerFactoryBean;
    }

//    private Properties jpaHibernateProperties() {
//
//        Properties properties = new Properties();
//
//        properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, env.getProperty(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH));
//        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE));
//        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE));
//        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//        return properties;
//    }
}
