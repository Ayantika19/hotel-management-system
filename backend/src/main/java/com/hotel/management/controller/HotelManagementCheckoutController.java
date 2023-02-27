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

import com.hotel.management.model.HotelManagementCheckout;
import com.hotel.management.service.HotelManagementCheckoutService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/checkout")
public class HotelManagementCheckoutController {

    @Autowired
    HotelManagementCheckoutService hotelManagementCheckoutService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newcheckout", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementCheckout> createHotelManagementCheckout (@RequestBody HotelManagementCheckout newhotelManagementCheckout) {
		System.out.println(newhotelManagementCheckout);
		HotelManagementCheckout newcheckout = hotelManagementCheckoutService.saveCheckout(newhotelManagementCheckout);
		return new ResponseEntity<HotelManagementCheckout>(newhotelManagementCheckout, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementCheckout> getCheckoutById(@PathVariable long id) {
		val findhotelManagementCheckout = hotelManagementCheckoutService.getCheckoutById(id);
		return new ResponseEntity<HotelManagementCheckout>(findhotelManagementCheckout, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementCheckout> updateCheckout(@PathVariable("id") long id, @RequestBody HotelManagementCheckout hotelManagementCheckout) {
		HotelManagementCheckout updatehotelManagementCheckout = hotelManagementCheckoutService.updateCheckout(hotelManagementCheckout, id);
		return new ResponseEntity<HotelManagementCheckout>(updatehotelManagementCheckout, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteCheckout(@PathVariable("id") long id) {
		hotelManagementCheckoutService.deleteCheckout(id);
		return new ResponseEntity<String>("Checkout deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allcheckout", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementCheckout> getAllCheckout() {
		return hotelManagementCheckoutService.getAllCheckout();
	}   
}
