package com.smiley.smiley.service;


import com.smiley.smiley.model.ContactPerson;
import com.smiley.smiley.model.School;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.repository.ContactPersonRepository;
import com.smiley.smiley.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ContactPersonService contactPersonService;

    public Student newStudent(Student student){
        return studentRepository.save(student);

    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public String deleteStudentById(long id){
            if (studentRepository.existsById(id)) {
                studentRepository.deleteById(id);
                return "hij's dood";
            }
            return "oeps";
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public Student updateStudentById(long id, Student student) {
        if (!studentRepository.existsById(id)) {
            return null;
        }

        Student oldStudent = studentRepository.findById(id).get();

        if (student.getName() != null) {
            oldStudent.setName(student.getName());
        }

        if (student.getSchoolClass() != null) {
            oldStudent.setSchoolClass(student.getSchoolClass());
        }

        if (student.getSchool() != null) {
            oldStudent.setSchool(student.getSchool());
        }

        return studentRepository.save(oldStudent);
    }

    public Student newStudentBySchool(School school, Student student) {
        student.setSchool(school);
        return studentRepository.save(student);
    }

    public Student addContactPersonToStudent(long id, ContactPerson contactPerson) {
        if (!studentRepository.existsById(id)) {
            return null;
        }

        Student student = studentRepository.findById(id).get();

        ContactPerson tempContactPerson = contactPersonService.newContactPerson(student, contactPerson);
        student.setContactPerson(tempContactPerson);
        return studentRepository.save(student);
    }

//    public Student updateSchoolForStudent(long id, School school) {
//    }
}
