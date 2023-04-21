package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelDetails;
import com.hotel.management.repository.HotelDetailsRepository;

@Service
public class HotelDetailsService {
	
	private HotelDetailsRepository hotelRepository;
	
	public HotelDetailsService(HotelDetailsRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public HotelDetails saveHotelDetails(HotelDetails hotelDetails) {
		return hotelRepository.save(hotelDetails);
	}
	
	public List<HotelDetails> getAllDetailsOfAllHotels() {
		return hotelRepository.findAll();
	}
	
	public HotelDetails getHotelDetailsById(long id) {
		Optional<HotelDetails> hotel = hotelRepository.findById(id);
		if (hotel.isPresent()) {
			return hotel.get();
		} else {
			throw new ResourceNotFoundException("Hotel", "HotelId", id);
		}
	}
	
	public HotelDetails updateHotelDetails(HotelDetails hotel, long id) {
		HotelDetails existingHotel = hotelRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Hotel", "HotelId", id)
				);
			existingHotel.setGymAvailable(hotel.getGymAvailable());
			existingHotel.setSwimmingPoolAvailable(hotel.getSwimmingPoolAvailable());
			existingHotel.setCarRentAvailable(hotel.getCarRentAvailable());
			existingHotel.setGameZoneAvailable(hotel.getGameZoneAvailable());
			existingHotel.setLaundryAvailable(hotel.getLaundryAvailable());
			existingHotel.setHotelName(hotel.getHotelName());
			existingHotel.setTotalRooms(hotel.getTotalRooms());
			existingHotel.setRoomsAvailable(hotel.getRoomsAvailable());
			existingHotel.setLocation(hotel.getLocation());
			existingHotel.setDiscounts(hotel.getDiscounts());
			existingHotel.setHotelItems(hotel.getHotelItems());
		    hotelRepository.save(existingHotel);
		    return existingHotel;
	}
	
	public void deleteHotel(long id) {
		hotelRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Hotel", "HotelId", id)
			);
            hotelRepository.deleteById(id);
	}
}
