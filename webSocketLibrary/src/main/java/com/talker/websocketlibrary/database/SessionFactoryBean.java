package com.talker.websocketlibrary.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

public class SessionFactoryBean {
    @Bean
    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }
}
