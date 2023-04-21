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

import com.hotel.management.model.Checkout;
import com.hotel.management.service.CheckoutService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/checkout", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Checkout> createCheckout (@RequestBody Checkout checkout) {
		System.out.println(checkout);
		Checkout newcheckout = checkoutService.saveCheckout(checkout);
		return new ResponseEntity<Checkout>(checkout, HttpStatus.CREATED);
	}

	@GetMapping(value="/checkout/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Checkout> getCheckoutById(@PathVariable long id) {
		val findcheckout = checkoutService.getCheckoutById(id);
		return new ResponseEntity<Checkout>(findcheckout, HttpStatus.OK);
	}

	@PutMapping(value="/checkout/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Checkout> updateCheckout(@PathVariable("id") long id, @RequestBody Checkout checkout) {
		Checkout updatecheckout = checkoutService.updateCheckout(checkout, id);
		return new ResponseEntity<Checkout>(updatecheckout, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/checkout/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCheckout(@PathVariable("id") long id) {
		checkoutService.deleteCheckout(id);
		return new ResponseEntity<String>("Checkout deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/checkout", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<Checkout> getAllCheckout() {
		return checkoutService.getAllCheckout();
	}   
}
