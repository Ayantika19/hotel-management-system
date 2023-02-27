package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementReservation;
import com.hotel.management.repository.HotelManagementReservationRepository;

@Service
public class HotelManagementReservationService {
	
	private HotelManagementReservationRepository hotelManagementReservationRepository;
	
	public HotelManagementReservationService(HotelManagementReservationRepository hotelManagementReservationRepository) {
		this.hotelManagementReservationRepository = hotelManagementReservationRepository;
	}

	public HotelManagementReservation saveReservation(HotelManagementReservation hotelManagementReservationRegistration) {
		return hotelManagementReservationRepository.save(hotelManagementReservationRegistration);
	}
	
	public List<HotelManagementReservation> getAllReservations() {
		return hotelManagementReservationRepository.findAll();
	}
	
	public HotelManagementReservation getReservationById(long id) {
		Optional<HotelManagementReservation> reservation = hotelManagementReservationRepository.findById(id);
		if (reservation.isPresent()) {
			return reservation.get();
		} else {
			throw new ResourceNotFoundException("Reservation", "BookingId", id);
		}
	}
	
	public HotelManagementReservation updateReservation(HotelManagementReservation reservation, long id) {
		HotelManagementReservation existingReservation = hotelManagementReservationRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Reservation", "BookingId", id)
				);
            existingReservation.setBookingStatus(reservation.getBookingStatus());
            existingReservation.setHotelManagementGuestRegistration(reservation.getHotelManagementGuestRegistration());
            existingReservation.setHotelManagementHotelFacilities(reservation.getHotelManagementHotelFacilities());
			existingReservation.setHotelManagementDiscounts(existingReservation.getHotelManagementDiscounts());
            existingReservation.setCity(reservation.getCity());
			existingReservation.setHouseNumber(reservation.getHouseNumber());
			existingReservation.setStreet(reservation.getStreet());
			existingReservation.setPincode(reservation.getPincode());
			existingReservation.setCountrycode(reservation.getCountryCode());
			existingReservation.setNumber(reservation.getNumber());
			existingReservation.setFromDate(reservation.getFromDate());		
			existingReservation.setToDate(reservation.getToDate());
			existingReservation.setIdentityProof(reservation.getIdentityProof());	
		    hotelManagementReservationRepository.save(existingReservation);
		    return existingReservation;
	}
	
	public void deleteReservation(long id) {
		hotelManagementReservationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Reservation", "BookingId", id)
			);
            hotelManagementReservationRepository.deleteById(id);
	}
}
