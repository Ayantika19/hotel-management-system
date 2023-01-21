package com.hotel.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementLocation;

public interface HotelManagementRepository extends JpaRepository<HotelManagementLocation,Long> {
    List<HotelManagementLocation> getAllLocationNames(String locationName);
    List<HotelManagementLocation> createTutorial(HotelManagementLocation location);
}