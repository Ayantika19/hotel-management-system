package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementItems;

public interface HotelManagementItemsRepository extends JpaRepository<HotelManagementItems, Long> {
    
}
