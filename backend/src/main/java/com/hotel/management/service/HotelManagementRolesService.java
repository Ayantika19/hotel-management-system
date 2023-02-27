package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementRoles;
import com.hotel.management.repository.HotelManagementRolesRepository;

@Service
public class HotelManagementRolesService {
	
	private HotelManagementRolesRepository hotelManagementRolesRepository;
	
	public HotelManagementRolesService(HotelManagementRolesRepository hotelManagementRolesRepository) {
		this.hotelManagementRolesRepository = hotelManagementRolesRepository;
	}

	public HotelManagementRoles saveRolesDetails(HotelManagementRoles hotelManagementRoles) {
		return hotelManagementRolesRepository.save(hotelManagementRoles);
	}
	
	public List<HotelManagementRoles> getAllRoles() {
		return hotelManagementRolesRepository.findAll();
	}
	
	public HotelManagementRoles getRolesById(long id) {
		Optional<HotelManagementRoles> roles = hotelManagementRolesRepository.findById(id);
		if (roles.isPresent()) {
			return roles.get();
		} else {
			throw new ResourceNotFoundException("Role", "RoleId", id);
		}
	}
	
	public HotelManagementRoles updateRolesDetails(HotelManagementRoles roles, long id) {
		HotelManagementRoles existingRoles = hotelManagementRolesRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Role", "RoleId", id)
				);
			existingRoles.setRoleName(roles.getRoleName());
            existingRoles.setHotelManagementPrivileges(roles.getHotelManagementPrivileges());
		    hotelManagementRolesRepository.save(existingRoles);
		    return existingRoles;
	}
	
	public void deleteRoles(long id) {
		hotelManagementRolesRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Role", "RoleId", id)
			);
            hotelManagementRolesRepository.deleteById(id);
	}
}
