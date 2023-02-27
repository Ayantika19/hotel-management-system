package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementRooms;
import com.hotel.management.repository.HotelManagementRoomsRepository;

@Service
public class HotelManagementRoomsService {
	
	private HotelManagementRoomsRepository hotelManagementRoomsRepository;
	
	public HotelManagementRoomsService(HotelManagementRoomsRepository hotelManagementRoomsRepository) {
		this.hotelManagementRoomsRepository = hotelManagementRoomsRepository;
	}

	public HotelManagementRooms saveRoomsDetails(HotelManagementRooms hotelManagementRooms) {
		return hotelManagementRoomsRepository.save(hotelManagementRooms);
	}
	
	public List<HotelManagementRooms> getAllRooms() {
		return hotelManagementRoomsRepository.findAll();
	}
	
	public HotelManagementRooms getRoomsById(long id) {
		Optional<HotelManagementRooms> rooms = hotelManagementRoomsRepository.findById(id);
		if (rooms.isPresent()) {
			return rooms.get();
		} else {
			throw new ResourceNotFoundException("Rooms", "RoomsId", id);
		}
	}
	
	public HotelManagementRooms updateRoomsDetails(HotelManagementRooms rooms, long id) {
		HotelManagementRooms existingRooms = hotelManagementRoomsRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Rooms", "RoomId", id)
				);
			existingRooms.setRoomCharges(rooms.getRoomCharges());
            existingRooms.setRoomNumber(rooms.getRoomNumber());
            existingRooms.setRoomType(rooms.getRoomType());
            existingRooms.setHotelManagementReservation(rooms.getHotelManagementReservation());
            existingRooms.setHotelManagementHotelDetails(rooms.getHotelManagementHotelDetails());
		    hotelManagementRoomsRepository.save(existingRooms);
		    return existingRooms;
	}
	
	public void deleteRooms(long id) {
		hotelManagementRoomsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Rooms", "RoomId", id)
			);
            hotelManagementRoomsRepository.deleteById(id);
	}
}
