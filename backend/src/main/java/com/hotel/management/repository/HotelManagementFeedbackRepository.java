package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementFeedback;

public interface HotelManagementFeedbackRepository extends JpaRepository <HotelManagementFeedback, Long> {
    
}
