package com.example.auth.controller;

import com.example.auth.model.Contact;
import com.example.auth.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public Contact save(@RequestBody Contact contact) {
        return this.contactService.save(contact);
    }

    @GetMapping("")
    public List<Contact> findAll() {
        return this.contactService.findAll();
    }
}
