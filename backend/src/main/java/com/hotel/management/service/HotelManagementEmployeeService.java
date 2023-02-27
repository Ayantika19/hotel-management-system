package com.hotel.management.service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementEmployeeRegistration;
import com.hotel.management.repository.HotelManagementEmployeeRepository;

@Service
public class HotelManagementEmployeeService {
	
	private HotelManagementEmployeeRepository hotelManagementEmployeeRepository;
	
	public HotelManagementEmployeeService(HotelManagementEmployeeRepository hotelManagementEmployeeRepository) {
		this.hotelManagementEmployeeRepository = hotelManagementEmployeeRepository;
	}

	public HotelManagementEmployeeRegistration saveEmployee(HotelManagementEmployeeRegistration hotelManagementEmployeeRegistration) {
		return hotelManagementEmployeeRepository.save(hotelManagementEmployeeRegistration);
	}
	
	public List<HotelManagementEmployeeRegistration> getAllEmployees() {
		return hotelManagementEmployeeRepository.findAll();
	}
	
	public HotelManagementEmployeeRegistration getEmployeeById(long id) {
		Optional<HotelManagementEmployeeRegistration> employee = hotelManagementEmployeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Employee", "EmployeeId", id);
		}
	}
	
	public HotelManagementEmployeeRegistration updateEmployee(HotelManagementEmployeeRegistration employee, long id) {
		HotelManagementEmployeeRegistration existingEmployee = hotelManagementEmployeeRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Employee", "EmployeeId", id)
				);
            existingEmployee.setfirstname(employee.getfirstname());
            existingEmployee.setlastname(employee.getlastname());
            existingEmployee.setEmailID(employee.getEmailID());
            existingEmployee.setPassword(employee.getPassword());
			existingEmployee.setDateOfBirth(employee.getDateOfBirth());
			existingEmployee.setHouseNumber(employee.getHouseNumber());
			existingEmployee.setStreet(employee.getStreet());
			existingEmployee.setCity(employee.getCity());
			existingEmployee.setPincode(employee.getPincode());
			existingEmployee.setEmailID(employee.getEmailID());
			existingEmployee.setCountrycode(employee.getCountryCode());
			existingEmployee.setNumber(employee.getNumber());
			existingEmployee.setHotelManagementRoles(employee.getHotelManagementRoles());
			existingEmployee.setHotelManagementHotelFacilities(employee.getHotelManagementLocation());			
		    hotelManagementEmployeeRepository.save(existingEmployee);
		    return existingEmployee;
	}
	
	public void deleteEmployee(long id) {
		hotelManagementEmployeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "EmployeeId", id)
			);
            hotelManagementEmployeeRepository.deleteById(id);
	}
}
