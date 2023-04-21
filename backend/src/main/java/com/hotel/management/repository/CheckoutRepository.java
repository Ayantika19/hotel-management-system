package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.Checkout;
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

}