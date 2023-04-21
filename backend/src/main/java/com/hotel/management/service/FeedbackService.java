package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Feedback;
import com.hotel.management.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	private FeedbackRepository feedbackRepository;
	
	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}
	
	public Feedback getFeedbackById(long id) {
		Optional<Feedback> feedback = feedbackRepository.findById(id);
		if (feedback.isPresent()) {
			return feedback.get();
		} else {
			throw new ResourceNotFoundException("Feedback", "FeedbackId", id);
		}
	}
	
	public Feedback updateFeedback(Feedback feedback, long id) {
		Feedback existingFeedback = feedbackRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Feedback", "FeedbackId", id)
				);
			existingFeedback.setRatings(feedback.getRatings());
            existingFeedback.setReservation(feedback.getCheckout());
		    feedbackRepository.save(existingFeedback);
		    return existingFeedback;
	}
	
	public void deleteFeedback(long id) {
		feedbackRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Feedback", "FeedbackId", id)
			);
            feedbackRepository.deleteById(id);
	}
}