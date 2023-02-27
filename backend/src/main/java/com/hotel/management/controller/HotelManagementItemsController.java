package com.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.model.HotelManagementItems;
import com.hotel.management.service.HotelManagementItemsService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/items")
public class HotelManagementItemsController {

    @Autowired
    HotelManagementItemsService hotelManagementItemsService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newitems", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementItems> createHotelManagementItems (@RequestBody HotelManagementItems newhotelManagementItems) {
		System.out.println(newhotelManagementItems);
		HotelManagementItems newitems = hotelManagementItemsService.saveItems(newhotelManagementItems);
		return new ResponseEntity<HotelManagementItems>(newhotelManagementItems, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementItems> getItemsById(@PathVariable long id) {
		val findhotelManagementItems = hotelManagementItemsService.getItemsById(id);
		return new ResponseEntity<HotelManagementItems>(findhotelManagementItems, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementItems> updateItems(@PathVariable("id") long id, @RequestBody HotelManagementItems hotelManagementItems) {
		HotelManagementItems updatehotelManagementItems = hotelManagementItemsService.updateItems(hotelManagementItems, id);
		return new ResponseEntity<HotelManagementItems>(updatehotelManagementItems, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteItems(@PathVariable("id") long id) {
		hotelManagementItemsService.deleteItems(id);
		return new ResponseEntity<String>("Items deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allitems", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementItems> getAllItems() {
		return hotelManagementItemsService.getAllItems();
	}   
}
