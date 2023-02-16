package com.smiley.smiley.service;


import com.smiley.smiley.model.ContactPerson;
import com.smiley.smiley.model.Student;
import com.smiley.smiley.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ContactPersonService {
    @Autowired
    ContactPersonRepository contactPersonRepository;

    public ContactPerson newContactPerson(Student student, ContactPerson contactPerson){
        return contactPersonRepository.save(contactPerson);

    }

    public Iterable<ContactPerson> getAllContactPersons() {
        return contactPersonRepository.findAll();
    }

    public Optional<ContactPerson> getContactPersonById(long id) {
        return contactPersonRepository.findById(id);
    }

    public String deleteContactPersonById(long id){
        if (contactPersonRepository.existsById(id)) {
            contactPersonRepository.deleteById(id);
            return "hij's dood";
        }
        return "oeps";
    }

    public void deleteAllContactPersons(){
        contactPersonRepository.deleteAll();
    }

    public ContactPerson updateContactPersonById(long id, ContactPerson contactPerson) {
        if (!contactPersonRepository.existsById(id)) {
            return null;
        }

        ContactPerson oldContactPerson = contactPersonRepository.findById(id).get();

        if (contactPerson.getName() != null) {
            oldContactPerson.setName(contactPerson.getName());
        }

        if (contactPerson.getStudent() != null) {
            oldContactPerson.setStudent(contactPerson.getStudent());
        }

        if (contactPerson.getPhoneNr() != null) {
            oldContactPerson.setPhoneNr(contactPerson.getPhoneNr());
        }

        return contactPersonRepository.save(oldContactPerson);
    }
}
