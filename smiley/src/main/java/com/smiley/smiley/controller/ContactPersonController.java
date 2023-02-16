package com.smiley.smiley.controller;


import com.smiley.smiley.model.ContactPerson;
import com.smiley.smiley.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/contactperson")
public class ContactPersonController {
    @Autowired
    ContactPersonService contactPersonService;

    // Create
    // http post
//    @PostMapping("/new")
//    public ContactPerson newContactPerson(@RequestBody ContactPerson contactPerson) {
//        return contactPersonService.newContactPerson(student, contactPerson);
//    }

    // Read
    // http get
    @GetMapping("/all")
    public Iterable<ContactPerson> getAllContactPersons() {
        return contactPersonService.getAllContactPersons();
    }

    @GetMapping("/{id}")
    public Optional<ContactPerson> getContactPersonById(@PathVariable(value = "id") long id) {
        return contactPersonService.getContactPersonById(id);
    }

    // Update
    // http put
    @PutMapping("/{id}")
    public ContactPerson updateContactPersonById(@PathVariable(value = "id") long id, @RequestBody ContactPerson contactPerson) {
        return contactPersonService.updateContactPersonById(id, contactPerson);
    }

    // Delete
    // http delete
    @DeleteMapping("/{id}")
    public String deleteContactPersonById(@PathVariable(value = "id") long id) {
        return contactPersonService.deleteContactPersonById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllContactPersons() {
        contactPersonService.deleteAllContactPersons();
    }
}
