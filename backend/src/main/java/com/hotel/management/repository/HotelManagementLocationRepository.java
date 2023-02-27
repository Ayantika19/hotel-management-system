package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementLocation;

public interface HotelManagementLocationRepository extends JpaRepository<HotelManagementLocation, Long> {

}