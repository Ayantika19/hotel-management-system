package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Checkout;
import com.hotel.management.repository.CheckoutRepository;

@Service
public class CheckoutService {
	
	private CheckoutRepository checkoutRepository;
	
	public CheckoutService(CheckoutRepository checkoutRepository) {
		this.checkoutRepository = checkoutRepository;
	}

	public Checkout saveCheckout(Checkout checkout) {
		return checkoutRepository.save(checkout);
	}
	
	public List<Checkout> getAllCheckout() {
		return checkoutRepository.findAll();
	}
	
	public Checkout getCheckoutById(long id) {
		Optional<Checkout> checkout = checkoutRepository.findById(id);
		if (checkout.isPresent()) {
			return checkout.get();
		} else {
			throw new ResourceNotFoundException("Checkout", "CheckoutId", id);
		}
	}
	
	public Checkout updateCheckout(Checkout checkout, long id) {
		Checkout existingCheckout = checkoutRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Checkout", "BillingId", id)
				);
			existingCheckout.setGST(checkout.getGST());
            existingCheckout.setItems(checkout.getItems());
            existingCheckout.setPaymentStatus(checkout.getPaymentStatus());
            existingCheckout.setTotalCharges(checkout.getTotalCharges());
            existingCheckout.setReservation(checkout.getReservation());
		    checkoutRepository.save(existingCheckout);
		    return existingCheckout;
	}
	
	public void deleteCheckout(long id) {
		checkoutRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Checkout", "BillingId", id)
			);
            checkoutRepository.deleteById(id);
	}
}