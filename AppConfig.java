package com.example.studentms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.studentms.service.StudentService;
import com.example.studentms.repository.StudentRepository; // if using custom DAO implementation
import com.example.studentms.dao.HibernateStudentDao;

@Configuration
public class AppConfig {

    // Example: if you implement your own DAO bean (Hibernate-based)
    @Bean
    public HibernateStudentDao studentDao(org.hibernate.SessionFactory sessionFactory) {
        return new HibernateStudentDao(sessionFactory);
    }

    // Service bean with constructor injection of the DAO
    @Bean
    public StudentService studentService(HibernateStudentDao dao) {
        return new StudentService(dao);
    }
}
