package com.example.backend.contactform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Repository
	public interface UserRepository extends CrudRepository<Contact, Long>{}
	
	Contact findByName(String name);

//	void update(Contact contact);




}
