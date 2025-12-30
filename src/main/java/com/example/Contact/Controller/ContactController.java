package com.example.Contact.Controller;

import com.example.Contact.Model.Contact;
import com.example.Contact.Service.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactServices service;

    // Create a new contact
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    // Get all contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return service.getContactById(id);
    }

    // Update contact
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    // Delete contact
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully");
    }
}
