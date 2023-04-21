package com.hotel.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.management.exception.ResourceNotFoundException;
import com.hotel.management.model.Items;
import com.hotel.management.repository.ItemsRepository;

@Service
public class ItemsService {

    private ItemsRepository hotelManagementItemsRepository;
	
	public ItemsService(ItemsRepository hotelManagementItemsRepository) {
		this.hotelManagementItemsRepository = hotelManagementItemsRepository;
	}

	public Items saveItems(Items hotelManagementItems) {
		return hotelManagementItemsRepository.save(hotelManagementItems);
	}
	
	public List<Items> getAllItems() {
		return hotelManagementItemsRepository.findAll();
	}
	
	public Items getItemsById(long id) {
		Optional<Items> Items = hotelManagementItemsRepository.findById(id);
		if (Items.isPresent()) {
			return Items.get();
		} else {
			throw new ResourceNotFoundException("Items", "ItemId", id);
		}
	}
	
	public Items updateItems(Items items, long id) {
		Items existingItems = hotelManagementItemsRepository.findById(id).orElseThrow(
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
