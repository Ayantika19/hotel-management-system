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

import com.hotel.management.model.Discounts;
import com.hotel.management.service.DiscountsService;

import lombok.val;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")

public class DiscountsController {

    @Autowired
    DiscountsService discountsService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/discount", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Discounts> createDiscounts (@RequestBody Discounts newhotelManagementDiscounts) {
		System.out.println(newhotelManagementDiscounts);
		Discounts newdiscount = discountsService.saveDiscount(newhotelManagementDiscounts);
		return new ResponseEntity<Discounts>(newhotelManagementDiscounts, HttpStatus.CREATED);
	}

	@GetMapping(value="/discount/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Discounts> getDiscountById(@PathVariable long id) {
		val findhotelManagementDiscounts = discountsService.getDiscountById(id);
		return new ResponseEntity<Discounts>(findhotelManagementDiscounts, HttpStatus.OK);
	}

	@PutMapping(value="/discount/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Discounts> updateDiscount(@PathVariable("id") long id, @RequestBody Discounts hotelManagementDiscounts) {
		Discounts updatehotelManagementDiscount = discountsService.updateDiscount(hotelManagementDiscounts, id);
		return new ResponseEntity<Discounts>(updatehotelManagementDiscount, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/discount/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteDiscount(@PathVariable("id") long id) {
		discountsService.deleteDiscount(id);
		return new ResponseEntity<String>("Discount deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/discount", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Discounts> getAllDiscounts() {
		return discountsService.getAllDiscounts();
	}   
}