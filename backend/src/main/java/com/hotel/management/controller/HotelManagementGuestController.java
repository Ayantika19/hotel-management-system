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

import com.hotel.management.model.HotelManagementGuestRegistration;
import com.hotel.management.service.HotelManagementGuestService;

@RestController
@RequestMapping("/api/hm/guests")
public class HotelManagementGuestController {

    @Autowired
    HotelManagementGuestService hotelManagementGuestService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newguest", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementGuestRegistration> createHotelManagementGuestRegistration (@RequestBody HotelManagementGuestRegistration newhotelManagementGuestRegistration) {
		System.out.println(newhotelManagementGuestRegistration);
		HotelManagementGuestRegistration newguest = hotelManagementGuestService.saveGuest(newhotelManagementGuestRegistration);
		return new ResponseEntity<HotelManagementGuestRegistration>(newhotelManagementGuestRegistration, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementGuestRegistration> getGuestById(@PathVariable long id) {
		HotelManagementGuestRegistration findhotelManagementGuestRegistration = hotelManagementGuestService.getGuestById(id);
		return new ResponseEntity<HotelManagementGuestRegistration>(findhotelManagementGuestRegistration, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementGuestRegistration> updateGuest(@PathVariable("id") long id, @RequestBody HotelManagementGuestRegistration hotelManagementGuestRegistration) {
		HotelManagementGuestRegistration updatehotelManagementGuestRegistration = hotelManagementGuestService.updateGuest(hotelManagementGuestRegistration, id);
		return new ResponseEntity<HotelManagementGuestRegistration>(updatehotelManagementGuestRegistration, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteGuest(@PathVariable("id") long id) {
		hotelManagementGuestService.deleteGuest(id);
		return new ResponseEntity<String>("Guest deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allguests", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementGuestRegistration> getAllGuests() {
		return hotelManagementGuestService.getAllGuests();
	}   
}
