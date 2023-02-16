package com.smiley.smiley.service;

import com.smiley.smiley.model.School;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.repository.SchoolRepository;
import com.smiley.smiley.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Optional;

@Service
@Transactional
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentService studentService;

    public School newSchool(School school){
        return schoolRepository.save(school);

    }

    public Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(long id) {
        return schoolRepository.findById(id);
    }

    public String deleteSchoolById(long id){
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return "hij's dood";
        }
        return "oeps";
    }

    public void deleteAllSchools(){
        schoolRepository.deleteAll();
    }

    public School updateSchoolById(long id, School school) {
        if (!schoolRepository.existsById(id)) {
            return null;
        }

        School oldSchool = schoolRepository.findById(id).get();

        if (school.getName() != null) {
            oldSchool.setName(school.getName());
        }

        if (school.getAmountOfStudents() != null) {
            oldSchool.setAmountOfStudents(school.getAmountOfStudents());
        }

        return schoolRepository.save(oldSchool);
    }

    public School newStudentBySchool(long id, Student student) {
        if (!schoolRepository.existsById(id)) {
            return null;
        }

        School school = schoolRepository.findById(id).get();
        Student tempStudent = studentService.newStudentBySchool(school, student);

        school.getStudents().add(tempStudent);

        return schoolRepository.save(school);
    }

    public Iterable<School> getSchoolByName(String name) {
        return schoolRepository.findByName(name);
    }
}
