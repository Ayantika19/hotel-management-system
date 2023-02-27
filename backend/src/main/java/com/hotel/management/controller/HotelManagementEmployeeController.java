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

import com.hotel.management.model.HotelManagementEmployeeRegistration;
import com.hotel.management.service.HotelManagementEmployeeService;

@RestController
@RequestMapping("/api/hm/employees")
public class HotelManagementEmployeeController {

    @Autowired
    HotelManagementEmployeeService hotelManagementEmployeeService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newemployee", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementEmployeeRegistration> createHotelManagementGuestRegistration (@RequestBody HotelManagementEmployeeRegistration newhotelManagementGuestRegistration) {
		System.out.println(newhotelManagementGuestRegistration);
		HotelManagementEmployeeRegistration newemployee = hotelManagementEmployeeService.saveEmployee(newhotelManagementGuestRegistration);
		return new ResponseEntity<HotelManagementEmployeeRegistration>(newhotelManagementGuestRegistration, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementEmployeeRegistration> getEmployeeById(@PathVariable long id) {
		HotelManagementEmployeeRegistration findhotelManagementGuestRegistration = hotelManagementEmployeeService.getEmployeeById(id);
		return new ResponseEntity<HotelManagementEmployeeRegistration>(findhotelManagementGuestRegistration, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementEmployeeRegistration> updateEmployee(@PathVariable("id") long id, @RequestBody HotelManagementEmployeeRegistration hotelManagementGuestRegistration) {
		HotelManagementEmployeeRegistration updatehotelManagementGuestRegistration = hotelManagementEmployeeService.updateEmployee(hotelManagementGuestRegistration, id);
		return new ResponseEntity<HotelManagementEmployeeRegistration>(updatehotelManagementGuestRegistration, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		hotelManagementEmployeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allemployees", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementEmployeeRegistration> getAllEmployees() {
		return hotelManagementEmployeeService.getAllEmployees();
	}   
}
