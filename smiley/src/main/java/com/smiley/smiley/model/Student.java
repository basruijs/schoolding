package com.smiley.smiley.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer schoolClass;
    @ManyToOne
    @JsonBackReference
    private School school;



//    private Long schoolId;
    @OneToOne
    private ContactPerson contactPerson;

    // default constructor
    public Student() {}

    // constructor om alle velden behalve id te zetten
    public Student(String name, Integer schoolClass) {
        this.name = name;
        this.schoolClass = schoolClass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Integer schoolClass) {
        this.schoolClass = schoolClass;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Long getSchoolId() {
        return school.getId();
    }

}
