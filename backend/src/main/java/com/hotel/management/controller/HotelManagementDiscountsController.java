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

import com.hotel.management.model.HotelManagementDiscounts;
import com.hotel.management.service.HotelManagementDiscountService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/discounts")
public class HotelManagementDiscountsController {

    @Autowired
    HotelManagementDiscountService hotelManagementDiscountService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newdiscount", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementDiscounts> createHotelManagementDiscounts (@RequestBody HotelManagementDiscounts newhotelManagementDiscounts) {
		System.out.println(newhotelManagementDiscounts);
		HotelManagementDiscounts newdiscount = hotelManagementDiscountService.saveDiscount(newhotelManagementDiscounts);
		return new ResponseEntity<HotelManagementDiscounts>(newhotelManagementDiscounts, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementDiscounts> getDiscountById(@PathVariable long id) {
		val findhotelManagementDiscounts = hotelManagementDiscountService.getDiscountById(id);
		return new ResponseEntity<HotelManagementDiscounts>(findhotelManagementDiscounts, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementDiscounts> updateDiscount(@PathVariable("id") long id, @RequestBody HotelManagementDiscounts hotelManagementDiscounts) {
		HotelManagementDiscounts updatehotelManagementDiscount = hotelManagementDiscountService.updateDiscount(hotelManagementDiscounts, id);
		return new ResponseEntity<HotelManagementDiscounts>(updatehotelManagementDiscount, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteDiscount(@PathVariable("id") long id) {
		hotelManagementDiscountService.deleteDiscount(id);
		return new ResponseEntity<String>("Discount deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/alldiscounts", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementDiscounts> getAllDiscounts() {
		return hotelManagementDiscountService.getAllDiscounts();
	}   
}
