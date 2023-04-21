package com.hotel.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.RoomsRepository;

@Service
public class RoomsService {
	
	private RoomsRepository roomsRepository;
	
	public RoomsService(RoomsRepository roomsRepository) {
		this.roomsRepository = roomsRepository;
	}

	public Rooms saveRoomsDetails(Rooms rooms) {
		return roomsRepository.save(rooms);
	}
	
	public List<Rooms> getAllRooms() {
		return roomsRepository.findAll();
	}
	
	public Rooms getRoomsById(long id) {
		Optional<Rooms> rooms = roomsRepository.findById(id);
		if (rooms.isPresent()) {
			return rooms.get();
		} else {
			throw new ResourceNotFoundException("Rooms", "RoomsId", id);
		}
	}
	
	public Rooms updateRoomsDetails(Rooms rooms, long id) {
		Rooms existingRooms = roomsRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Rooms", "RoomId", id)
				);
			existingRooms.setRoomCharges(rooms.getRoomCharges());
            existingRooms.setRoomNumber(rooms.getRoomNumber());
            existingRooms.setRoomType(rooms.getRoomType());
            existingRooms.setReservation(rooms.getReservation());
            existingRooms.setHotelDetails(rooms.getHotelDetails());
		    roomsRepository.save(existingRooms);
		    return existingRooms;
	}
	
	public void deleteRooms(long id) {
		roomsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Rooms", "RoomId", id)
			);
            roomsRepository.deleteById(id);
	}
}