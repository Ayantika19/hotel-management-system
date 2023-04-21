package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelDetails;

public interface HotelDetailsRepository extends JpaRepository<HotelDetails, Long> {

}
