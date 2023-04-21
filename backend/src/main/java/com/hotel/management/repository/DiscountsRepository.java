package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.Discounts;
public interface DiscountsRepository extends JpaRepository<Discounts, Long> {

}