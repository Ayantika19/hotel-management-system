package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementDiscounts;
public interface HotelManagementDiscountRepository extends JpaRepository<HotelManagementDiscounts, Long> {

}