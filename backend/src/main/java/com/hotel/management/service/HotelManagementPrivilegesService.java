package com.hotel.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementPrivileges;
import com.hotel.management.repository.HotelManagementPrivilegesRepository;

@Service
public class HotelManagementPrivilegesService {
	
	private HotelManagementPrivilegesRepository hotelManagementPrivilegesRepository;
	
	public HotelManagementPrivilegesService(HotelManagementPrivilegesRepository hotelManagementPrivilegesRepository) {
		this.hotelManagementPrivilegesRepository = hotelManagementPrivilegesRepository;
	}

	public HotelManagementPrivileges savePrivilegesDetails(HotelManagementPrivileges hotelManagementPrivileges) {
		return hotelManagementPrivilegesRepository.save(hotelManagementPrivileges);
	}
	
	public List<HotelManagementPrivileges> getAllPrivileges() {
		return hotelManagementPrivilegesRepository.findAll();
	}
	
	public HotelManagementPrivileges getPrivilegesById(long id) {
		Optional<HotelManagementPrivileges> privileges = hotelManagementPrivilegesRepository.findById(id);
		if (privileges.isPresent()) {
			return privileges.get();
		} else {
			throw new ResourceNotFoundException("Privilege", "PrivilegeId", id);
		}
	}
	
	public HotelManagementPrivileges updatePrivilegesDetails(HotelManagementPrivileges privileges, long id) {
		HotelManagementPrivileges existingPrivileges = hotelManagementPrivilegesRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Privilege", "PrivilegeId", id)
				);
			existingPrivileges.setPrivilegeModule(privileges.getPrivilegeModule());
			existingPrivileges.setHotelManagementRoles(privileges.getHotelManagementRoles());
		    hotelManagementPrivilegesRepository.save(existingPrivileges);
		    return existingPrivileges;
	}
	
	public void deletePrivileges(long id) {
		hotelManagementPrivilegesRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Privilege", "PrivilegeId", id)
			);
            hotelManagementPrivilegesRepository.deleteById(id);
	}
}
