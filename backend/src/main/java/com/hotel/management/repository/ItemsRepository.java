package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

}
