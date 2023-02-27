package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementGuestRegistration;
import com.hotel.management.repository.HotelManagementGuestRepository;

@Service
public class HotelManagementGuestService {
	
	private HotelManagementGuestRepository hotelManagementGuestRepository;
	
	public HotelManagementGuestService(HotelManagementGuestRepository hotelManagementGuestRepository) {
		this.hotelManagementGuestRepository = hotelManagementGuestRepository;
	}

	public HotelManagementGuestRegistration saveGuest(HotelManagementGuestRegistration hotelManagementGuestRegistration) {
		return hotelManagementGuestRepository.save(hotelManagementGuestRegistration);
	}
	
	public List<HotelManagementGuestRegistration> getAllGuests() {
		return hotelManagementGuestRepository.findAll();
	}
	
	public HotelManagementGuestRegistration getGuestById(long id) {
		Optional<HotelManagementGuestRegistration> guest = hotelManagementGuestRepository.findById(id);
		if (guest.isPresent()) {
			return guest.get();
		} else {
			throw new ResourceNotFoundException("Guest", "GuestId", id);
		}
	}
	
	public HotelManagementGuestRegistration updateGuest(HotelManagementGuestRegistration guest, long id) {
		HotelManagementGuestRegistration existingGuest = hotelManagementGuestRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Guest", "GuestId", id)
				);
        existingGuest.setfirstname(guest.getfirstname());
        existingGuest.setlastname(guest.getlastname());
        existingGuest.setEmailID(guest.getEmailID());
        existingGuest.setPassword(guest.getPassword());
		existingGuest.setHotelManagementRoles(guest.getHotelManagementRoles());
		hotelManagementGuestRepository.save(existingGuest);
		return existingGuest;
	}
	
	public void deleteGuest(long id) {
		hotelManagementGuestRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Guest", "GuestId", id)
			);
            hotelManagementGuestRepository.deleteById(id);
	}
}