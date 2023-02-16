package com.smiley.smiley.controller;

import com.smiley.smiley.model.ContactPerson;
import com.smiley.smiley.model.School;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Create
    // http post
    @PostMapping("/new")
    public Student newStudent(@RequestBody Student student) {
        return studentService.newStudent(student);
    }

    // Read
    // http get
    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(value = "id") long id) {
        return studentService.getStudentById(id);
    }

    // Update
    // http put
    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    // Delete
    // http delete
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable(value = "id") long id) {
        return studentService.deleteStudentById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

    @PutMapping("/{id}/newContactPerson")
    public Student addContactPerson(@PathVariable(value = "id") long id, @RequestBody ContactPerson contactPerson) {
        return studentService.addContactPersonToStudent(id, contactPerson);
    }
}
