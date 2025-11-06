package com.example.studentms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.studentms.dao.HibernateStudentDao;
import com.example.studentms.entity.Student;

@Service
public class StudentService {

    private final HibernateStudentDao dao;

    public StudentService(HibernateStudentDao dao) {
        this.dao = dao;
    }

    @Transactional
    public Student create(Student s) {
        return dao.save(s);
    }

    @Transactional(readOnly = true)
    public Student getById(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return dao.findAll();
    }

    @Transactional
    public Student update(Long id, Student newData) {
        Student exist = dao.findById(id);
        if (exist == null) throw new RuntimeException("Not found");
        exist.setFirstName(newData.getFirstName());
        exist.setLastName(newData.getLastName());
        exist.setEmail(newData.getEmail());
        exist.setCourse(newData.getCourse());
        return dao.update(exist);
    }

    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
