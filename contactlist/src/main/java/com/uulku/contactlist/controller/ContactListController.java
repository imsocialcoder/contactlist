package com.uulku.contactlist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uulku.contactlist.dto.ContactDto;
import com.uulku.contactlist.service.ContactListService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/contactlist")
@AllArgsConstructor
public class ContactListController {
	private final ContactListService contactListService;

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ContactDto>> getAllContacts(){
		return ResponseEntity.ok(contactListService.getAllContacts());
	}
	
	@GetMapping("/paging")
	public ResponseEntity<List<ContactDto>> getAllContacts(@RequestParam int page, @RequestParam int size){
		return ResponseEntity.ok(contactListService.getContactsByPaging(page, size));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<ContactDto>> getContactsByName(@PathVariable String name){
		return ResponseEntity.ok(contactListService.getContactsByName(name));
	}
}
