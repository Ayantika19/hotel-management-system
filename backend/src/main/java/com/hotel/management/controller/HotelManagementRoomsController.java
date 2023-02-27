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

import com.hotel.management.model.HotelManagementRooms;
import com.hotel.management.service.HotelManagementRoomsService;

import lombok.val;

@RestController
@RequestMapping("/api/hm/rooms")
public class HotelManagementRoomsController {

    @Autowired
    HotelManagementRoomsService hotelManagementRoomsService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/newrooms", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRooms> createHotelManagementRooms (@RequestBody HotelManagementRooms newhotelManagementRooms) {
		System.out.println(newhotelManagementRooms);
		HotelManagementRooms newrooms = hotelManagementRoomsService.saveRoomsDetails(newhotelManagementRooms);
		return new ResponseEntity<HotelManagementRooms>(newhotelManagementRooms, HttpStatus.CREATED);
	}

	@GetMapping(value="/find/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRooms> getRoomsById(@PathVariable long id) {
		val findhotelManagementRooms = hotelManagementRoomsService.getRoomsById(id);
		return new ResponseEntity<HotelManagementRooms>(findhotelManagementRooms, HttpStatus.OK);
	}

	@PutMapping(value="/update/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<HotelManagementRooms> updateRooms(@PathVariable("id") long id, @RequestBody HotelManagementRooms hotelManagementRooms) {
		HotelManagementRooms updatehotelManagementRooms = hotelManagementRoomsService.updateRoomsDetails(hotelManagementRooms, id);
		return new ResponseEntity<HotelManagementRooms>(updatehotelManagementRooms, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{id}", produces = APPLICATION_VND_API_JSON)
	public ResponseEntity<String> deleteRooms(@PathVariable("id") long id) {
		hotelManagementRoomsService.deleteRooms(id);
		return new ResponseEntity<String>("Rooms deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/allrooms", produces = APPLICATION_VND_API_JSON)
	public List<HotelManagementRooms> getAllRooms() {
		return hotelManagementRoomsService.getAllRooms();
	}   
}
