package com.uulku.contactlist.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.uulku.contactlist.dto.ContactDto;
import com.uulku.contactlist.model.Contact;
import com.uulku.contactlist.repo.ContactRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactListService {
	private final ContactRepository contactRepository;
	
	public List<ContactDto> getAllContacts(){
		return StreamSupport.stream(contactRepository.findAll().spliterator(), false)
                .map(contact -> this.mapContactToContactDto(contact))
                .toList();
	}
	
	public List<ContactDto> getContactsByPaging(int page, int size){
		PageRequest pageable = PageRequest.of(page, size);
		return StreamSupport.stream(contactRepository.findAll(pageable).spliterator(), false)
                .map(contact -> this.mapContactToContactDto(contact))
                .toList();
	}
	
	public List<ContactDto> getContactsByName(String name){
		return contactRepository.findByName(name).stream()
                .map(contact -> this.mapContactToContactDto(contact))
                .toList();
	}
	
	public ContactDto mapContactToContactDto (Contact contact){
        return ContactDto.builder()
        		.id(contact.getId())
                .name(contact.getName())
                .path(contact.getPath())
                .build();
    }
}
