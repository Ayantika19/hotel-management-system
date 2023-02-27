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

import com.hotel.management.model.HotelManagementLocation;
import com.hotel.management.service.HotelManagementLocationService;

@RestController
@RequestMapping("/api/hm/location")
public class HotelManagementLocationController {

    @Autowired
    HotelManagementLocationService hotelManagementLocationService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newlocation", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementLocation> createNewLocationDetails (@RequestBody HotelManagementLocation newhotelManagementHotelDetails) {
		System.out.println(newhotelManagementHotelDetails);
		HotelManagementLocation newLocation = hotelManagementLocationService.saveLocationDetails(newhotelManagementHotelDetails);
		return new ResponseEntity<HotelManagementLocation>(newhotelManagementHotelDetails, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementLocation> getLocationById(@PathVariable long id) {
		HotelManagementLocation findhotelManagementHotelDetails = hotelManagementLocationService.getLocationById(id);
		return new ResponseEntity<HotelManagementLocation>(findhotelManagementHotelDetails, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementLocation> updateLocationDetails(@PathVariable("id") long id, @RequestBody HotelManagementLocation hotelManagementHotelDetails) {
		HotelManagementLocation updatehotelManagementHotelDetails = hotelManagementLocationService.updateLocationDetails(hotelManagementHotelDetails, id);
		return new ResponseEntity<HotelManagementLocation>(updatehotelManagementHotelDetails, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteHotel(@PathVariable("id") long id) {
		hotelManagementLocationService.deleteLocation(id);
		return new ResponseEntity<String>("Location deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/alllocations", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementLocation> getAllLocationsAvailable() {
		return hotelManagementLocationService.getAllLocationsAvailable();
	}   
}
