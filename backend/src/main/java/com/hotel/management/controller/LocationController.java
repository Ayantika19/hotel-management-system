package com.hotel.management.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hotel.management.model.Location;
import com.hotel.management.service.LocationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class LocationController {

    @Autowired
    LocationService locationService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/location", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Location> createNewLocationDetails (@RequestBody Location newLocationDetails) {
		Location newLocation = locationService.saveLocationDetails(newLocationDetails);
		return new ResponseEntity<Location>(newLocationDetails, HttpStatus.CREATED);
	}

	@GetMapping(value="/location/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Location> getLocationById(@PathVariable long id) {
		Location findLocationDetails = locationService.getLocationById(id);
		return new ResponseEntity<Location>(findLocationDetails, HttpStatus.OK);
	}

	@PutMapping(value="/location/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Location> updateLocationDetails(@PathVariable("id") long id, @RequestBody Location locationDetails) {
		Location updateLocationDetails = locationService.updateLocationDetails(locationDetails, id);
		return new ResponseEntity<Location>(updateLocationDetails, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/location/{id}", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteLocation(@PathVariable("id") long id) {
		locationService.deleteLocation(id);
		return new ResponseEntity<String>("Location deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/location", produces = APPLICATION_VND_API_JSON)
    @PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<Location> getAllLocationsAvailable() {
		return locationService.getAllLocationsAvailable();
	}   
}
