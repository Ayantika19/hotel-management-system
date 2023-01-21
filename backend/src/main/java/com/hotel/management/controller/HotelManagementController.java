package com.hotel.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.model.*;
import com.hotel.management.repository.HotelManagementRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class HotelManagementController {

	@Autowired
	HotelManagementRepository hotelManagementRepository;

	@GetMapping("/location")
	public ResponseEntity<List<HotelManagementLocation>> getAllLocationNames(@RequestParam(required = false) String locationName) {
		try {
			List<HotelManagementLocation> location = new ArrayList<HotelManagementLocation>();

			if (locationName == null)
				hotelManagementRepository.findAll().forEach(location::add);
			// else
			// 	hotelManagementRepository.findByTitleContaining(locationName).forEach(location::add);

			if (location.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(location, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @GetMapping("/tutorials/{id}")
	// public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
	// 	Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	// 	if (tutorialData.isPresent()) {
	// 		return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	@PostMapping("/add/location")
	public ResponseEntity<HotelManagementLocation> createTutorial(@RequestBody HotelManagementLocation location) {
		try {
			HotelManagementLocation _tutorial = hotelManagementRepository
					.save(new HotelManagementLocation(location.getLocationName(), location.getHotelId(), location.getcreationDate(), location.getlastUpdated()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}