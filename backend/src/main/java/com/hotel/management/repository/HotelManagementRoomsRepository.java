package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementRooms;

public interface HotelManagementRoomsRepository extends JpaRepository<HotelManagementRooms, Long> {
    
}
