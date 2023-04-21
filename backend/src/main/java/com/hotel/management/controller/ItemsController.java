package com.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hotel.management.model.Items;
import com.hotel.management.service.ItemsService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class ItemsController {

    @Autowired
    ItemsService itemsService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/items", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<Items> createItems (@RequestBody Items newItems) {
		System.out.println(newItems);
		Items newitems = itemsService.saveItems(newItems);
		return new ResponseEntity<Items>(newItems, HttpStatus.CREATED);
	}

	@GetMapping(value="/items/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Items> getItemsById(@PathVariable long id) {
		val finditems = itemsService.getItemsById(id);
		return new ResponseEntity<Items>(finditems, HttpStatus.OK);
	}

	@PutMapping(value="/items/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<Items> updateItems(@PathVariable("id") long id, @RequestBody Items items) {
		Items updateitems = itemsService.updateItems(items, id);
		return new ResponseEntity<Items>(updateitems, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/items/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteItems(@PathVariable("id") long id) {
		itemsService.deleteItems(id);
		return new ResponseEntity<String>("Items deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/items", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<Items> getAllItems() {
		return itemsService.getAllItems();
	}   
}

