package com.micorservice.course.microservicecourse.service;

import com.micorservice.course.microservicecourse.client.StudentCllient;
import com.micorservice.course.microservicecourse.dto.StudentDTO;
import com.micorservice.course.microservicecourse.entities.Course;
import com.micorservice.course.microservicecourse.http.StudentByCourseResponse;
import com.micorservice.course.microservicecourse.persistence.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursesServiceImpl implements ICourseService{
    @Autowired
    private ICoursesRepository iCoursesRepository;
    @Autowired
    private StudentCllient studentCllient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCoursesRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCoursesRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCoursesRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        Course course = iCoursesRepository.findById(idCourse).orElse(new Course());
        //obtener los estudiantes
        List<StudentDTO> studenDTOList = (List<StudentDTO>) studentCllient.findAllStudentsByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studenDTOList)
                .build();
    }
}
