package com.example.backend.contactform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	private Object httpClient;

	/*Get method*/
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
	
	/*Post Method*/
	public Contact create(Contact contact) {
        return contactRepository.save(contact);
        
    }
	
	public void addContact(Contact contact) {
		contactRepository.save(contact);
		
	}
	
	/*Put Method*/
//	public void updateContact(Contact contact) {
//		contactRepository.update(contact);
//	}
	
	/*Delete method*/
	  public void deleteContact(Contact contact) {
		  contactRepository.delete(contact);
		  
/*		    return this.httpClient.delete<contact>("http://localhost:8083/contact/contacts" + "/"+ contact.getContactId()); */
		  }

	public List<Contact> deleteOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*Delete method*/
	public void deleteContact(final long id) {
        try {
        	Contact contact = new Contact();
        	contact.setContactId(id);
        	contactRepository.delete(contact);
        } catch (Exception e) {
            // throw error exception
            throw e;
        }
    }

}
