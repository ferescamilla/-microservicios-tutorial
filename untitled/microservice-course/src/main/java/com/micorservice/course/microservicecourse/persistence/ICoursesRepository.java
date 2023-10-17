package com.micorservice.course.microservicecourse.persistence;

import com.micorservice.course.microservicecourse.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursesRepository extends CrudRepository<Course,Long> {
}
