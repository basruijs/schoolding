package com.smiley.smiley.repository;

import com.smiley.smiley.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
