package com.hotel.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Reservation;
import com.hotel.management.repository.ReservationRepository;

@Service
public class ReservationService {
	
	private ReservationRepository reservationRepository;
	
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public Reservation saveReservation(Reservation reservationRegistration) {
		return reservationRepository.save(reservationRegistration);
	}
	
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}
	
	public Reservation getReservationById(long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if (reservation.isPresent()) {
			return reservation.get();
		} else {
			throw new ResourceNotFoundException("Reservation", "BookingId", id);
		}
	}
	
	public Reservation updateReservation(Reservation reservation, long id) {
		Reservation existingReservation = reservationRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Reservation", "BookingId", id)
				);
            existingReservation.setBookingStatus(reservation.getBookingStatus());
            existingReservation.setUser(reservation.getUser());
            existingReservation.setHotelDetails(reservation.getHotelDetails());
			existingReservation.setDiscounts(existingReservation.getDiscounts());
            existingReservation.setCity(reservation.getCity());
			existingReservation.setHouseNumber(reservation.getHouseNumber());
			existingReservation.setStreet(reservation.getStreet());
			existingReservation.setPincode(reservation.getPincode());
			existingReservation.setCountrycode(reservation.getCountryCode());
			existingReservation.setNumber(reservation.getNumber());
			existingReservation.setFromDate(reservation.getFromDate());		
			existingReservation.setToDate(reservation.getToDate());
			existingReservation.setIdentityProof(reservation.getIdentityProof());	
		    reservationRepository.save(existingReservation);
		    return existingReservation;
	}
	
	public void deleteReservation(long id) {
		reservationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Reservation", "BookingId", id)
			);
            reservationRepository.deleteById(id);
	}
}