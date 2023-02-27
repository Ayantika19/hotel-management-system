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

import com.hotel.management.model.HotelManagementFeedback;
import com.hotel.management.service.HotelManagementFeedbackService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/feedback")
public class HotelManagementFeedbackController {

    @Autowired
    HotelManagementFeedbackService hotelManagementFeedbackService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newfeedback", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementFeedback> createHotelManagementGuestRegistration (@RequestBody HotelManagementFeedback newhotelManagementFeedback) {
		System.out.println(newhotelManagementFeedback);
		HotelManagementFeedback newfeedback = hotelManagementFeedbackService.saveFeedback(newhotelManagementFeedback);
		return new ResponseEntity<HotelManagementFeedback>(newhotelManagementFeedback, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementFeedback> getFeedbackById(@PathVariable long id) {
		val findhotelManagementFeedback = hotelManagementFeedbackService.getFeedbackById(id);
		return new ResponseEntity<HotelManagementFeedback>(findhotelManagementFeedback, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementFeedback> updateFeedback(@PathVariable("id") long id, @RequestBody HotelManagementFeedback hotelManagementFeedback) {
		HotelManagementFeedback updatehotelManagementFeedback = hotelManagementFeedbackService.updateFeedback(hotelManagementFeedback, id);
		return new ResponseEntity<HotelManagementFeedback>(updatehotelManagementFeedback, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteFeedback(@PathVariable("id") long id) {
		hotelManagementFeedbackService.deleteFeedback(id);
		return new ResponseEntity<String>("Feedback deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allfeedback", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementFeedback> getAllFeedback() {
		return hotelManagementFeedbackService.getAllFeedback();
	}   
}
