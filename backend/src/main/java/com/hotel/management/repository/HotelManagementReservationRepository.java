package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementReservation;

public interface HotelManagementReservationRepository extends JpaRepository<HotelManagementReservation, Long> {
    
}
