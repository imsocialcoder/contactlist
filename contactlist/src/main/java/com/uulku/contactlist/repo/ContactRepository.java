package com.uulku.contactlist.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uulku.contactlist.model.Contact;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {
	List<Contact> findByName(String name);
} 
