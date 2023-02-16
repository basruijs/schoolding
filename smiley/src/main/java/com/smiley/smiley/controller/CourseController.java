package com.smiley.smiley.controller;

import com.smiley.smiley.model.Course;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    // Create
    // http post
    @PostMapping("/new")
    public Course newCourse(@RequestBody Course course) {
        return courseService.newCourse(course);
    }

    // Read
    // http get
    @GetMapping("/all")
    public Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable(value = "id") long id) {
        return courseService.getCourseById(id);
    }

    // Update
    // http put
    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable(value = "id") long id, @RequestBody Course course) {
        return courseService.updateCourseById(id, course);
    }

    // Delete
    // http delete
    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable(value = "id") long id) {
        return courseService.deleteCourseById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }

    }

