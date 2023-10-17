package com.micorservice.student.microservicestudent.service;

import com.micorservice.student.microservicestudent.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);


}
