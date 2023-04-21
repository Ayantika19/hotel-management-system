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

import com.hotel.management.model.Feedback;
import com.hotel.management.service.FeedbackService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/feedback", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('GUEST')")
	public ResponseEntity<Feedback> createGuestRegistration (@RequestBody Feedback newfeedback) {
		System.out.println(newfeedback);
		Feedback feedback = feedbackService.saveFeedback(newfeedback);
		return new ResponseEntity<Feedback>(newfeedback, HttpStatus.CREATED);
	}

	@GetMapping(value="/feedback/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable long id) {
		val findfeedback = feedbackService.getFeedbackById(id);
		return new ResponseEntity<Feedback>(findfeedback, HttpStatus.OK);
	}

	@GetMapping(value="/feedback", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}   
}
