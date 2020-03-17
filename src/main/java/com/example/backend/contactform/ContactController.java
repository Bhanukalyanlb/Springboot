package com.example.backend.contactform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value= "/contact")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	private List<Contact> contacts = createList();
	
	@RequestMapping(value= "/contacts", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> getAll() {
		return contactRepository.findAll();
		
		/*List<Contact> contacts = contactService.getAll();
		if(contacts != null) {
			if(contacts.size() > 0) {*/
				
	/*	return contacts;*/
	
	}

	/* @PostMapping(value= "/contacts")
	 void addContact(@RequestBody Contact contact) {
		 contactRepository.save(contact);
	 }
	 
	 */
	
	
	    /*private Contact getOne(@RequestParam long contactId) {
		 Contact contact = contactService.getOne(contactId);
	        if(contact != null) {
	        	
	            return contact;
	        }
	        return null;
	    }*/
	
	private static List<Contact> createList() {
		List<Contact> tempContacts = new ArrayList<>();
		Contact cont1 = new Contact();
		cont1.setContactId(1);
		cont1.setName("Bhanu");
		cont1.setCountry("Thailand");
		cont1.setSubject("Learning springboot");
		
		Contact cont2 = new Contact();
		cont2.setContactId(2);
		cont2.setName("Kalyan");
		cont2.setCountry("Japan");
		cont2.setSubject("Learning Angular 8");
		
		tempContacts.add(cont1);
		tempContacts.add(cont2);
		
		return tempContacts;
	}
	
}
