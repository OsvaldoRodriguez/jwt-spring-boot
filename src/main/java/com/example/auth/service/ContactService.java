package com.example.auth.service;

import com.example.auth.model.Contact;
import com.example.auth.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return this.contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }


}
