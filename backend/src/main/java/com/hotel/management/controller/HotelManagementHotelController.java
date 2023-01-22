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
import com.hotel.management.repository.HotelManagementHotelRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class HotelManagementHotelController {

	@Autowired
	HotelManagementHotelRepository hotelManagementHotelRepository;

	@GetMapping(path="/all/locations")
	public ResponseEntity<List<HotelManagementLocation>> getAllLocationNames() {
		try {
			List<HotelManagementLocation> location = new ArrayList<HotelManagementLocation>();
			
			hotelManagementHotelRepository.findAll().forEach(location::add);
			
			if (location.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(location, HttpStatus.OK);

		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}

	@PostMapping("/add/location")
	public ResponseEntity<HotelManagementLocation> addNewLocation(@RequestBody HotelManagementLocation location) {
		try {
				HotelManagementLocation newLocation = hotelManagementHotelRepository
						.save(new HotelManagementLocation(location.getLocationName(), location.getHotelId(), 
														location.getcreationDate(), location.getlastUpdated()));
				return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}