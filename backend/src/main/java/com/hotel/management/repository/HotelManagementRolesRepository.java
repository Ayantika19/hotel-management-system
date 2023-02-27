package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementRoles;

public interface HotelManagementRolesRepository extends JpaRepository<HotelManagementRoles, Long> {
    
}
