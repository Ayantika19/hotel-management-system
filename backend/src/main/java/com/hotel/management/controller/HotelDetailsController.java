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

import com.hotel.management.model.HotelDetails;
import com.hotel.management.service.HotelDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class HotelDetailsController {

    @Autowired
    HotelDetailsService hotelService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/hotel", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<HotelDetails> createHotelDetails (@RequestBody HotelDetails newhotelDetails) {
		System.out.println(newhotelDetails);
		HotelDetails newhotel = hotelService.saveHotelDetails(newhotelDetails);
		return new ResponseEntity<HotelDetails>(newhotelDetails, HttpStatus.CREATED);
	}

	@GetMapping(value="/hotel/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<HotelDetails> getHotelDetailsById(@PathVariable long id) {
		HotelDetails findhotelDetails = hotelService.getHotelDetailsById(id);
		return new ResponseEntity<HotelDetails>(findhotelDetails, HttpStatus.OK);
	}

	@PutMapping(value="/hotel/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<HotelDetails> updateHotelDetails(@PathVariable("id") long id, @RequestBody HotelDetails hotelDetails) {
		HotelDetails updatehotelDetails = hotelService.updateHotelDetails(hotelDetails, id);
		return new ResponseEntity<HotelDetails>(updatehotelDetails, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/hotel/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") long id) {
		hotelService.deleteHotel(id);
		return new ResponseEntity<String>("Hotel deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/hotel", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<HotelDetails> getAllHotels() {
		return hotelService.getAllDetailsOfAllHotels();
	}
}
