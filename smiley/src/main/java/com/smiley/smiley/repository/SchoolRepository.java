package com.smiley.smiley.repository;


import com.smiley.smiley.model.School;
import com.smiley.smiley.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SchoolRepository extends CrudRepository<School, Long> {
    Iterable<School> findByName(String name);
    Integer countByName(String Name);
}
