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

import com.hotel.management.model.HotelManagementHotelDetails;
import com.hotel.management.service.HotelManagementHotelService;

@RestController
@RequestMapping("/api/hm/hotel")
public class HotelManagementHotelController {

    @Autowired
    HotelManagementHotelService hotelManagementHotelService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newhotel", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementHotelDetails> createHotelManagementHotelDetails (@RequestBody HotelManagementHotelDetails newhotelManagementHotelDetails) {
		System.out.println(newhotelManagementHotelDetails);
		HotelManagementHotelDetails newhotel = hotelManagementHotelService.saveHotelDetails(newhotelManagementHotelDetails);
		return new ResponseEntity<HotelManagementHotelDetails>(newhotelManagementHotelDetails, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementHotelDetails> getHotelDetailsById(@PathVariable long id) {
		HotelManagementHotelDetails findhotelManagementHotelDetails = hotelManagementHotelService.getHotelDetailsById(id);
		return new ResponseEntity<HotelManagementHotelDetails>(findhotelManagementHotelDetails, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementHotelDetails> updateHotelDetails(@PathVariable("id") long id, @RequestBody HotelManagementHotelDetails hotelManagementHotelDetails) {
		HotelManagementHotelDetails updatehotelManagementHotelDetails = hotelManagementHotelService.updateHotelDetails(hotelManagementHotelDetails, id);
		return new ResponseEntity<HotelManagementHotelDetails>(updatehotelManagementHotelDetails, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteHotel(@PathVariable("id") long id) {
		hotelManagementHotelService.deleteHotel(id);
		return new ResponseEntity<String>("Hotel deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allhotels", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementHotelDetails> getAllHotels() {
		return hotelManagementHotelService.getAllDetailsOfAllHotels();
	}
}
