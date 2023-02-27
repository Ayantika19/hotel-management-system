package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.HotelManagementCheckout;

public interface HotelManagementCheckoutRepository extends JpaRepository<HotelManagementCheckout, Long> {

}