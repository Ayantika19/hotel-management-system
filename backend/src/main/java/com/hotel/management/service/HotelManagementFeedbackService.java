package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementFeedback;
import com.hotel.management.repository.HotelManagementFeedbackRepository;

@Service
public class HotelManagementFeedbackService {
	
	private HotelManagementFeedbackRepository hotelManagementFeedbackRepository;
	
	public HotelManagementFeedbackService(HotelManagementFeedbackRepository hotelManagementFeedbackRepository) {
		this.hotelManagementFeedbackRepository = hotelManagementFeedbackRepository;
	}

	public HotelManagementFeedback saveFeedback(HotelManagementFeedback hotelManagementFeedback) {
		return hotelManagementFeedbackRepository.save(hotelManagementFeedback);
	}
	
	public List<HotelManagementFeedback> getAllFeedback() {
		return hotelManagementFeedbackRepository.findAll();
	}
	
	public HotelManagementFeedback getFeedbackById(long id) {
		Optional<HotelManagementFeedback> feedback = hotelManagementFeedbackRepository.findById(id);
		if (feedback.isPresent()) {
			return feedback.get();
		} else {
			throw new ResourceNotFoundException("Feedback", "FeedbackId", id);
		}
	}
	
	public HotelManagementFeedback updateFeedback(HotelManagementFeedback feedback, long id) {
		HotelManagementFeedback existingFeedback = hotelManagementFeedbackRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Feedback", "FeedbackId", id)
				);
			existingFeedback.setRatings(feedback.getRatings());
            existingFeedback.setHotelManagementReservation(feedback.getHotelManagementCheckout());
		    hotelManagementFeedbackRepository.save(existingFeedback);
		    return existingFeedback;
	}
	
	public void deleteFeedback(long id) {
		hotelManagementFeedbackRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Feedback", "FeedbackId", id)
			);
            hotelManagementFeedbackRepository.deleteById(id);
	}
}
