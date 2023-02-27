package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementLocation;
import com.hotel.management.repository.HotelManagementLocationRepository;

@Service
public class HotelManagementLocationService {
	
	private HotelManagementLocationRepository hotelManagementLocationRepository;
	
	public HotelManagementLocationService(HotelManagementLocationRepository hotelManagementLocationRepository) {
		this.hotelManagementLocationRepository = hotelManagementLocationRepository;
	}

	public HotelManagementLocation saveLocationDetails(HotelManagementLocation hotelManagementLocation) {
		return hotelManagementLocationRepository.save(hotelManagementLocation);
	}
	
	public List<HotelManagementLocation> getAllLocationsAvailable() {
		return hotelManagementLocationRepository.findAll();
	}
	
	public HotelManagementLocation getLocationById(long id) {
		Optional<HotelManagementLocation> location = hotelManagementLocationRepository.findById(id);
		if (location.isPresent()) {
			return location.get();
		} else {
			throw new ResourceNotFoundException("Location", "LocationId", id);
		}
	}
	
	public HotelManagementLocation updateLocationDetails(HotelManagementLocation location, long id) {
		HotelManagementLocation existingLocation = hotelManagementLocationRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Location", "LocationId", id)
				);
			existingLocation.setLocationName(location.getLocationName());
		    hotelManagementLocationRepository.save(existingLocation);
		    return existingLocation;
	}
	
	public void deleteLocation(long id) {
		hotelManagementLocationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Location", "LocationId", id)
			);
            hotelManagementLocationRepository.deleteById(id);
	}
}
