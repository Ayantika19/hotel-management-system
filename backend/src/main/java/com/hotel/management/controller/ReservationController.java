package com.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.model.Reservation;
import com.hotel.management.service.ReservationService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/reservation", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Reservation> createReservation (@RequestBody Reservation newreservation) {
		System.out.println(newreservation);
		Reservation reservation = reservationService.saveReservation(newreservation);
		return new ResponseEntity<Reservation>(newreservation, HttpStatus.CREATED);
	}

	@GetMapping(value="/reservation/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Reservation> getReservationById(@PathVariable long id) {
		val findreservation = reservationService.getReservationById(id);
		return new ResponseEntity<Reservation>(findreservation, HttpStatus.OK);
	}

	@PutMapping(value="/reservation/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation) {
		Reservation updatereservation = reservationService.updateReservation(reservation, id);
		return new ResponseEntity<Reservation>(updatereservation, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/reservation/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteReservation(@PathVariable("id") long id) {
		reservationService.deleteReservation(id);
		return new ResponseEntity<String>("Reservation deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/reservation", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<Reservation> getAllReservation() {
		return reservationService.getAllReservations();
	}   
}
