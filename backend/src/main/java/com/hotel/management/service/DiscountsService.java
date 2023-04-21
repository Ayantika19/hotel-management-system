package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Discounts;
import com.hotel.management.repository.DiscountsRepository;

@Service
public class DiscountsService {
	
	private DiscountsRepository discountsRepository;
	
	public DiscountsService(DiscountsRepository discountsRepository) {
		this.discountsRepository = discountsRepository;
	}

	public Discounts saveDiscount(Discounts DiscountRegistration) {
		return discountsRepository.save(DiscountRegistration);
	}
	
	public List<Discounts> getAllDiscounts() {
		return discountsRepository.findAll();
	}
	
	public Discounts getDiscountById(long id) {
		Optional<Discounts> discount = discountsRepository.findById(id);
		if (discount.isPresent()) {
			return discount.get();
		} else {
			throw new ResourceNotFoundException("Discount", "DiscountId", id);
		}
	}
	
	public Discounts updateDiscount(Discounts discount, long id) {
		Discounts existingDiscount = discountsRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Discount", "DiscountId", id)
				);
        existingDiscount.setCompanyName(discount.getCompanyName());
        existingDiscount.setHouseNumber(discount.getHouseNumber());
		existingDiscount.setStreet(discount.getStreet());
		existingDiscount.setCity(discount.getCity());
		existingDiscount.setPincode(discount.getPincode());
        existingDiscount.setEmailID(discount.getEmailID());
        existingDiscount.setCountrycode(discount.getCountrycode());
		existingDiscount.setNumber(discount.getNumber());
		existingDiscount.setRebate(discount.getRebate());
		//existingDiscount.setHotelDetails(discount.getHotelDetails());
		discountsRepository.save(existingDiscount);
		return existingDiscount;
	}
	
	public void deleteDiscount(long id) {
		discountsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Discount", "DiscountId", id)
			);
            discountsRepository.deleteById(id);
	}
} 
