package com.micorservice.course.microservicecourse.service;

import com.micorservice.course.microservicecourse.entities.Course;
import com.micorservice.course.microservicecourse.http.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
