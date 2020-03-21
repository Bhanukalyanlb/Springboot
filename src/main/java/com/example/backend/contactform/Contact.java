package com.example.backend.contactform;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name= "contactform")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contactId;
	
	private String name;
	private String country;
	private String subject;

	public static final String CONTACT_ID = "contact_id";
	public static final String CONTACT_NAME = "contact_name";
	public static final String CONTACT_COUNTRY = "contact_country";
	public static final String CONTACT_SUBJECT = "contact_subject";
	public Map<String, ?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
