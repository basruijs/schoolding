package com.smiley.smiley.controller;

import com.smiley.smiley.model.School;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    // Create
    // http post
    @PostMapping("/new")
    public School newSchool(@RequestBody School school) {
        return schoolService.newSchool(school);
    }

    // Read
    // http get
    @GetMapping("/all")
    public Iterable<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public Optional<School> getSchoolById(@PathVariable(value = "id") long id) {
        return schoolService.getSchoolById(id);
    }

    @GetMapping("/name/{name}")
    public Iterable<School> getSchoolByName(@PathVariable(value = "name") String name) {
        return schoolService.getSchoolByName(name);
    }

    // Update
    // http put
    @PutMapping("/{id}")
    public School updateSchoolById(@PathVariable(value = "id") long id, @RequestBody School school) {
        return schoolService.updateSchoolById(id, school);
    }

    // Delete
    // http delete
    @DeleteMapping("/{id}")
    public String deleteSchoolById(@PathVariable(value = "id") long id) {
        return schoolService.deleteSchoolById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllSchools() {
        schoolService.deleteAllSchools();
    }

    @PutMapping("/{id}/newStudent")
    public School newStudentBySchool(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return schoolService.newStudentBySchool(id, student);
    }
}
