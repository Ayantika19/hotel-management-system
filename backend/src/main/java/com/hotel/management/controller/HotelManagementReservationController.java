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

import com.hotel.management.model.HotelManagementReservation;
import com.hotel.management.service.HotelManagementReservationService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/reservation")
public class HotelManagementReservationController {

    @Autowired
    HotelManagementReservationService hotelManagementReservationService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newreservation", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementReservation> createHotelManagementReservation (@RequestBody HotelManagementReservation newhotelManagementReservation) {
		System.out.println(newhotelManagementReservation);
		HotelManagementReservation newreservation = hotelManagementReservationService.saveReservation(newhotelManagementReservation);
		return new ResponseEntity<HotelManagementReservation>(newhotelManagementReservation, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementReservation> getReservationById(@PathVariable long id) {
		val findhotelManagementReservation = hotelManagementReservationService.getReservationById(id);
		return new ResponseEntity<HotelManagementReservation>(findhotelManagementReservation, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementReservation> updateReservation(@PathVariable("id") long id, @RequestBody HotelManagementReservation hotelManagementReservation) {
		HotelManagementReservation updatehotelManagementReservation = hotelManagementReservationService.updateReservation(hotelManagementReservation, id);
		return new ResponseEntity<HotelManagementReservation>(updatehotelManagementReservation, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteReservation(@PathVariable("id") long id) {
		hotelManagementReservationService.deleteReservation(id);
		return new ResponseEntity<String>("Reservation deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allreservation", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementReservation> getAllReservation() {
		return hotelManagementReservationService.getAllReservations();
	}   
}
