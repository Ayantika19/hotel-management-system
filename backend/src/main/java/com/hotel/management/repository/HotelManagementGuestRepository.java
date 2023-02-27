package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementGuestRegistration;
public interface HotelManagementGuestRepository extends JpaRepository<HotelManagementGuestRegistration, Long> {

}
