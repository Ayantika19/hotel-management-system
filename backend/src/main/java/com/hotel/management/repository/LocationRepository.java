package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management.model.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
