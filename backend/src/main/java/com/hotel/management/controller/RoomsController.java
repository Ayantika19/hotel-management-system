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

import com.hotel.management.model.Rooms;
import com.hotel.management.service.RoomsService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/hm")
public class RoomsController {

    @Autowired
    RoomsService roomsService;
    
    private static final String APPLICATION_VND_API_JSON = "application/json";

    @PostMapping(value ="/rooms", produces = APPLICATION_VND_API_JSON , consumes = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<Rooms> createRooms (@RequestBody Rooms newrooms) {
		System.out.println(newrooms);
		Rooms rooms = roomsService.saveRoomsDetails(newrooms);
		return new ResponseEntity<Rooms>(newrooms, HttpStatus.CREATED);
	}

	@GetMapping(value="/rooms/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public ResponseEntity<Rooms> getRoomsById(@PathVariable long id) {
		val findrooms = roomsService.getRoomsById(id);
		return new ResponseEntity<Rooms>(findrooms, HttpStatus.OK);
	}

	@PutMapping(value="/rooms/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<Rooms> updateRooms(@PathVariable("id") long id, @RequestBody Rooms rooms) {
		Rooms updaterooms = roomsService.updateRoomsDetails(rooms, id);
		return new ResponseEntity<Rooms>(updaterooms, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/rooms/{id}", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteRooms(@PathVariable("id") long id) {
		roomsService.deleteRooms(id);
		return new ResponseEntity<String>("Rooms deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value="/rooms", produces = APPLICATION_VND_API_JSON)
	@PreAuthorize("hasRole('GUEST') or hasRole('MANAGER') or hasRole('FRONTENDEMPLOYEE') or hasRole('ADMIN')")
	public List<Rooms> getAllRooms() {
		return roomsService.getAllRooms();
	}   
}
