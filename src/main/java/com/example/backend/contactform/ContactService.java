package com.example.backend.contactform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}
	
	public Contact getOne(long contactId) {
		return contactRepository.getOne(new Long(contactId));
	}

	public Contact getByName(String name) {
		return contactRepository.findByName(name);
		
	}
	
	public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }
}
