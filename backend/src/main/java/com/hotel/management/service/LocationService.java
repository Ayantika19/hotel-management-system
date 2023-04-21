package com.hotel.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Location;
import com.hotel.management.repository.LocationRepository;

@Service
public class LocationService {
	
	private LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public Location saveLocationDetails(Location location) {
		return locationRepository.save(location);
	}
	
	public List<Location> getAllLocationsAvailable() {
		return locationRepository.findAll();
	}
	
	public Location getLocationById(long id) {
		Optional<Location> location = locationRepository.findById(id);
		if (location.isPresent()) {
			return location.get();
		} else {
			throw new ResourceNotFoundException("Location", "LocationId", id);
		}
	}
	
	public Location updateLocationDetails(Location location, long id) {
		Location existingLocation = locationRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Location", "LocationId", id)
				);
			existingLocation.setLocationName(location.getLocationName());
		    locationRepository.save(existingLocation);
		    return existingLocation;
	}
	
	public void deleteLocation(long id) {
		locationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Location", "LocationId", id)
			);
            locationRepository.deleteById(id);
	}
}

