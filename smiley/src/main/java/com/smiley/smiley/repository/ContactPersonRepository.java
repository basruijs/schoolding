package com.smiley.smiley.repository;


import com.smiley.smiley.model.ContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactPersonRepository extends CrudRepository<ContactPerson, Long> {
}
