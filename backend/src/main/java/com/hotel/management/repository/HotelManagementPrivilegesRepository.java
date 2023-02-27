package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementPrivileges;

public interface HotelManagementPrivilegesRepository extends JpaRepository<HotelManagementPrivileges, Long> {
    
}
