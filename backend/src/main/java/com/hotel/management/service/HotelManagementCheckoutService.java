package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementCheckout;
import com.hotel.management.repository.HotelManagementCheckoutRepository;

@Service
public class HotelManagementCheckoutService {
	
	private HotelManagementCheckoutRepository hotelManagementCheckoutRepository;
	
	public HotelManagementCheckoutService(HotelManagementCheckoutRepository hotelManagementCheckoutRepository) {
		this.hotelManagementCheckoutRepository = hotelManagementCheckoutRepository;
	}

	public HotelManagementCheckout saveCheckout(HotelManagementCheckout hotelManagementCheckout) {
		return hotelManagementCheckoutRepository.save(hotelManagementCheckout);
	}
	
	public List<HotelManagementCheckout> getAllCheckout() {
		return hotelManagementCheckoutRepository.findAll();
	}
	
	public HotelManagementCheckout getCheckoutById(long id) {
		Optional<HotelManagementCheckout> checkout = hotelManagementCheckoutRepository.findById(id);
		if (checkout.isPresent()) {
			return checkout.get();
		} else {
			throw new ResourceNotFoundException("Checkout", "CheckoutId", id);
		}
	}
	
	public HotelManagementCheckout updateCheckout(HotelManagementCheckout checkout, long id) {
		HotelManagementCheckout existingCheckout = hotelManagementCheckoutRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Checkout", "BillingId", id)
				);
			existingCheckout.setGST(checkout.getGST());
            existingCheckout.setHotelManagementItems(checkout.getHotelManagementItems());
            existingCheckout.setPaymentStatus(checkout.getPaymentStatus());
            existingCheckout.setTotalCharges(checkout.getTotalCharges());
            existingCheckout.setHotelManagementReservation(checkout.getHotelManagementReservation());
		    hotelManagementCheckoutRepository.save(existingCheckout);
		    return existingCheckout;
	}
	
	public void deleteCheckout(long id) {
		hotelManagementCheckoutRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Checkout", "BillingId", id)
			);
            hotelManagementCheckoutRepository.deleteById(id);
	}
}
