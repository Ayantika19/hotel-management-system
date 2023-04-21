package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.model.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    
}
