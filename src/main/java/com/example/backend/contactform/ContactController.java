package com.example.backend.contactform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
/*import crud.example.backend.models.MapReturn; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.MapReturn;


@RestController
@RequestMapping(value= "/contact")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ContactController {
	
	 @Autowired  
	    private SessionFactory sessionFactory;
	
	private static final Object newContact = null;

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactService contactService;
	
	private List<Contact> contacts = createList();
	
	@RequestMapping(value= "/contacts", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> getAll() {
		List<Contact> contactList = contactService.getAll();
		return contactList;
		
		/*List<Contact> contacts = contactService.getAll();
		if(contacts != null) {
			if(contacts.size() > 0) {*/
				
	/*	return contacts;*/
	
	}

	/* @PostMapping("/contacts")
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
		
		/*Contact cont1 = new Contact();
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
		tempContacts.add(cont2);*/
		
		return tempContacts;
	}
	
	/*PostMapping*/
	
	/*@PostMapping(value= "/addContacts", method= RequestMethod.POST)
	public ResponseEntity<Object> createContact(@RequestBody Contact contact){
		Contact savedContact = contactRepository.save(contact);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedcontact.getAll()).toUri();
		return ResponseEntity.created(location).build();
	}*/
	
	
	/*Baeldung process*/
	
	/*@PostMapping(value= "/addContacts")
	void addContact(@RequestBody Contact contact) {
		 contactRepository.save(contact);
	 }
	
	@SuppressWarnings("unused")
	private static List<Contact> createNewList() {
		List<Contact> tempContacts = new ArrayList<>();
		return tempContacts;
	
	}*/
	
	//Mkyong
	
	/*@PostMapping(value= "/addContacts")
	@ResponseStatus(HttpStatus.CREATED)
	Contact newContact(@Valid @RequestBody Contact newBook) {
		return contactRepository.save(newContact);
    }*/
	
	
	/*@SuppressWarnings("unused")
	@PostMapping(value= "/addContact")
	public @ResponseBody ResponseEntity<Contact> post() {
		Object contact;
		contactRepository.saveAll(contacts);
		return new ResponseEntity<Contact>(HttpStatus.OK);
		
	}*/
	
	/*@PostMapping (value= "/addContacts")
	public Contact create(@RequestBody Contact contact) {
		contacts.add(user);
		System.out.println(contacts);
		return user;
	}*/
	
	@PostMapping (value= "/AddContact")
	@ResponseBody
	
	private Map<String, ?> addContact(@RequestBody Contact contact) {
		String message;
        try {
        	 contactService.addContact(contact);
        	 return MapReturn.objReturn(null, 1, "Add contact", "success");
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        return MapReturn.objReturn(null, 0, message, "fail");
	}
	
	/* @PostMapping("/addContacts")
	    public ResponseEntity < Contact > createContact(@RequestBody Contact contact) {
	        return ResponseEntity.ok().body(this.contactService.createContact(contact));
	    }*/

	 
	 /*Getter-Setter*/
	 
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	/*Delete Contact*/
	  public boolean deleteContact(Contact contact) {  
	        boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().delete(contact);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	    }
	  
	  /*Delete method ~ Get method*/
	  
	  @RequestMapping(value= "/contacts", method = RequestMethod.DELETE, produces = "application/json")
		public List<Contact> deleteOne() {
			List<Contact> contactList = contactService.deleteOne();
			return contactList;
	
}
	  
	  /*Delete Contact*/
	  @DeleteMapping("/deleteContact")
	    public String delete(@RequestParam Contact contactId) {
	        String msg;
	        try {
	            contactService.deleteContact(contactId);
	            msg = "Delete data success!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            msg = e.getMessage();
	        }
	        return msg;
	    }
	  
}
