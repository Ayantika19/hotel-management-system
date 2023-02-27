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

import com.hotel.management.model.HotelManagementPrivileges;
import com.hotel.management.service.HotelManagementPrivilegesService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/privileges")
public class HotelManagementPrivilegesController {

    @Autowired
    HotelManagementPrivilegesService hotelManagementPrivilegesService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newprivilege", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementPrivileges> createHotelManagementPrivileges (@RequestBody HotelManagementPrivileges newhotelManagementPrivileges) {
		System.out.println(newhotelManagementPrivileges);
		HotelManagementPrivileges newprivileges = hotelManagementPrivilegesService.savePrivilegesDetails(newhotelManagementPrivileges);
		return new ResponseEntity<HotelManagementPrivileges>(newhotelManagementPrivileges, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementPrivileges> getPrivilegesById(@PathVariable long id) {
		val findhotelManagementPrivileges = hotelManagementPrivilegesService.getPrivilegesById(id);
		return new ResponseEntity<HotelManagementPrivileges>(findhotelManagementPrivileges, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementPrivileges> updatePrivileges(@PathVariable("id") long id, @RequestBody HotelManagementPrivileges hotelManagementPrivileges) {
		HotelManagementPrivileges updatehotelManagementPrivileges = hotelManagementPrivilegesService.updatePrivilegesDetails(hotelManagementPrivileges, id);
		return new ResponseEntity<HotelManagementPrivileges>(updatehotelManagementPrivileges, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deletePrivileges(@PathVariable("id") long id) {
		hotelManagementPrivilegesService.deletePrivileges(id);
		return new ResponseEntity<String>("Privileges deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allprivileges", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementPrivileges> getAllPrivileges() {
		return hotelManagementPrivilegesService.getAllPrivileges();
	}   
}
