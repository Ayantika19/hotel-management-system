package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementDiscounts;
import com.hotel.management.repository.HotelManagementDiscountRepository;

@Service
public class HotelManagementDiscountService {
	
	private HotelManagementDiscountRepository hotelManagementDiscountsRepository;
	
	public HotelManagementDiscountService(HotelManagementDiscountRepository hotelManagementDiscountsRepository) {
		this.hotelManagementDiscountsRepository = hotelManagementDiscountsRepository;
	}

	public HotelManagementDiscounts saveDiscount(HotelManagementDiscounts hotelManagementDiscountRegistration) {
		return hotelManagementDiscountsRepository.save(hotelManagementDiscountRegistration);
	}
	
	public List<HotelManagementDiscounts> getAllDiscounts() {
		return hotelManagementDiscountsRepository.findAll();
	}
	
	public HotelManagementDiscounts getDiscountById(long id) {
		Optional<HotelManagementDiscounts> discount = hotelManagementDiscountsRepository.findById(id);
		if (discount.isPresent()) {
			return discount.get();
		} else {
			throw new ResourceNotFoundException("Discount", "DiscountId", id);
		}
	}
	
	public HotelManagementDiscounts updateDiscount(HotelManagementDiscounts discount, long id) {
		HotelManagementDiscounts existingDiscount = hotelManagementDiscountsRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Discount", "DiscountId", id)
				);
        existingDiscount.setCompanyName(discount.getCompanyName());
        existingDiscount.setHouseNumber(discount.getHouseNumber());
		existingDiscount.setStreet(discount.getStreet());
		existingDiscount.setCity(discount.getCity());
		existingDiscount.setPincode(discount.getPincode());
        existingDiscount.setEmailID(discount.getEmailID());
        existingDiscount.setCountrycode(discount.getCountryCode());
		existingDiscount.setNumber(discount.getNumber());
		existingDiscount.setHotelManagementHotelDetails(discount.getHotelManagementHotelDetails());
		hotelManagementDiscountsRepository.save(existingDiscount);
		return existingDiscount;
	}
	
	public void deleteDiscount(long id) {
		hotelManagementDiscountsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Discount", "DiscountId", id)
			);
            hotelManagementDiscountsRepository.deleteById(id);
	}
}