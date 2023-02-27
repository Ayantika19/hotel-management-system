package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementHotelDetails;
import com.hotel.management.repository.HotelManagementHotelRepository;

@Service
public class HotelManagementHotelService {
	
	private HotelManagementHotelRepository hotelManagementHotelRepository;
	
	public HotelManagementHotelService(HotelManagementHotelRepository hotelManagementHotelRepository) {
		this.hotelManagementHotelRepository = hotelManagementHotelRepository;
	}

	public HotelManagementHotelDetails saveHotelDetails(HotelManagementHotelDetails hotelManagementHotelDetails) {
		return hotelManagementHotelRepository.save(hotelManagementHotelDetails);
	}
	
	public List<HotelManagementHotelDetails> getAllDetailsOfAllHotels() {
		return hotelManagementHotelRepository.findAll();
	}
	
	public HotelManagementHotelDetails getHotelDetailsById(long id) {
		Optional<HotelManagementHotelDetails> hotel = hotelManagementHotelRepository.findById(id);
		if (hotel.isPresent()) {
			return hotel.get();
		} else {
			throw new ResourceNotFoundException("Hotel", "HotelId", id);
		}
	}
	
	public HotelManagementHotelDetails updateHotelDetails(HotelManagementHotelDetails hotel, long id) {
		HotelManagementHotelDetails existingHotel = hotelManagementHotelRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Hotel", "HotelId", id)
				);
			existingHotel.setGymAvailable(hotel.getGymAvailable());
			existingHotel.setSwimmingPoolAvailable(hotel.getSwimmingPoolAvailable());
			existingHotel.setCarRentAvailable(hotel.getCarRentAvailable());
			existingHotel.setGameZoneAvailable(hotel.getGameZoneAvailable());
			existingHotel.setLaundryAvailable(hotel.getLaundryAvailable());
			existingHotel.setTotalRooms(hotel.getTotalRooms());
			existingHotel.setRoomsAvailable(hotel.getRoomsAvailable());
			existingHotel.setHotelManagementLocation(hotel.getHotelManagementLocation());
			existingHotel.setHotelManagementDiscounts(hotel.getHotelManagementDiscounts());
			existingHotel.setHotelManagementHotelItems(hotel.getHotelManagementHotelItems());
		    hotelManagementHotelRepository.save(existingHotel);
		    return existingHotel;
	}
	
	public void deleteHotel(long id) {
		hotelManagementHotelRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Hotel", "HotelId", id)
			);
            hotelManagementHotelRepository.deleteById(id);
	}
}
