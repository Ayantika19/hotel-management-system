package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementEmployeeRegistration;
public interface HotelManagementEmployeeRepository extends JpaRepository<HotelManagementEmployeeRegistration, Long> {

}