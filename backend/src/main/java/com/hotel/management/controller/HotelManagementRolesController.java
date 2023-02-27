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

import com.hotel.management.model.HotelManagementRoles;
import com.hotel.management.service.HotelManagementRolesService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/roles")
public class HotelManagementRolesController {

    @Autowired
    HotelManagementRolesService hotelManagementRolesService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newrole", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRoles> createHotelManagementRoles (@RequestBody HotelManagementRoles newhotelManagementRoles) {
		System.out.println(newhotelManagementRoles);
		HotelManagementRoles newroles = hotelManagementRolesService.saveRolesDetails(newhotelManagementRoles);
		return new ResponseEntity<HotelManagementRoles>(newhotelManagementRoles, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRoles> getRolesById(@PathVariable long id) {
		val findhotelManagementRoles = hotelManagementRolesService.getRolesById(id);
		return new ResponseEntity<HotelManagementRoles>(findhotelManagementRoles, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRoles> updateRoles(@PathVariable("id") long id, @RequestBody HotelManagementRoles hotelManagementRoles) {
		HotelManagementRoles updatehotelManagementRoles = hotelManagementRolesService.updateRolesDetails(hotelManagementRoles, id);
		return new ResponseEntity<HotelManagementRoles>(updatehotelManagementRoles, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteRoles(@PathVariable("id") long id) {
		hotelManagementRolesService.deleteRoles(id);
		return new ResponseEntity<String>("Roles deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allroles", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementRoles> getAllRoles() {
		return hotelManagementRolesService.getAllRoles();
	}   
}
