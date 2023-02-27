package com.hotel.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.HotelManagementItems;
import com.hotel.management.repository.HotelManagementItemsRepository;

@Service
public class HotelManagementItemsService {

    private HotelManagementItemsRepository hotelManagementItemsRepository;
	
	public HotelManagementItemsService(HotelManagementItemsRepository hotelManagementItemsRepository) {
		this.hotelManagementItemsRepository = hotelManagementItemsRepository;
	}

	public HotelManagementItems saveItems(HotelManagementItems hotelManagementItems) {
		return hotelManagementItemsRepository.save(hotelManagementItems);
	}
	
	public List<HotelManagementItems> getAllItems() {
		return hotelManagementItemsRepository.findAll();
	}
	
	public HotelManagementItems getItemsById(long id) {
		Optional<HotelManagementItems> Items = hotelManagementItemsRepository.findById(id);
		if (Items.isPresent()) {
			return Items.get();
		} else {
			throw new ResourceNotFoundException("Items", "ItemId", id);
		}
	}
	
	public HotelManagementItems updateItems(HotelManagementItems items, long id) {
		HotelManagementItems existingItems = hotelManagementItemsRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Items", "ItemId", id)
				);
			existingItems.setCharges(items.getCharges());
            existingItems.setItemName(items.getItemName());
		    hotelManagementItemsRepository.save(existingItems);
		    return existingItems;
	}
	
	public void deleteItems(long id) {
		hotelManagementItemsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Items", "ItemId", id)
			);
            hotelManagementItemsRepository.deleteById(id);
	}
}
