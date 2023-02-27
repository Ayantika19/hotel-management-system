package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementHotelDetails;
public interface HotelManagementHotelRepository extends JpaRepository<HotelManagementHotelDetails, Long> {

}
