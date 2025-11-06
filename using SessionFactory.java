package com.example.studentms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.studentms.entity.Student;

@Repository
public class HibernateStudentDao {

    private final SessionFactory sessionFactory;

    public HibernateStudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Student save(Student student) {
        currentSession().persist(student);
        return student;
    }

    public Student findById(Long id) {
        return currentSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        return currentSession().createQuery("from Student", Student.class).list();
    }

    public Student update(Student s) {
        currentSession().merge(s);
        return s;
    }

    public void delete(Long id) {
        Student s = findById(id);
        if (s != null) currentSession().remove(s);
    }
}
