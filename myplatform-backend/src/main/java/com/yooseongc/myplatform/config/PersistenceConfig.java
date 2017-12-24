package com.yooseongc.myplatform.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("database").build());
//        em.setPackagesToScan("com.yooseongc.myplatform.entity");
//
//        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(jpaVendorAdapter);
//
//        return em;
//    }

    @Bean
    public ServletRegistrationBean h2ServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");

        return registrationBean;
    }

    // Transaction 설정
    /*@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }*/
}
