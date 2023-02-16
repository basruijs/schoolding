package com.smiley.smiley.service;

import com.smiley.smiley.model.Course;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentService studentService;

    public Course newCourse(Course course){
        return courseRepository.save(course);

    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    public String deleteCourseById(long id){
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return "hij's dood";
        }
        return "oeps";
    }

    public void deleteAllCourses(){
        courseRepository.deleteAll();
    }

    public Course updateCourseById(long id, Course course) {
        if (!courseRepository.existsById(id)) {
            return null;
        }

        Course oldCourse = courseRepository.findById(id).get();

        if (course.getName() != null) {
            oldCourse.setName(course.getName());
        }

        if (course.getCredits() != null) {
            oldCourse.setCredits(course.getCredits());
        }

        return courseRepository.save(oldCourse);
    }

}
